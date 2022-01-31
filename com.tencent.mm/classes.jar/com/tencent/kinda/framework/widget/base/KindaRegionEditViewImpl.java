package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import com.tencent.kinda.framework.app.UIPageFragmentActivity;
import com.tencent.kinda.framework.app.UIPageFragmentActivity.IntentHandler;
import com.tencent.kinda.gen.KRegionEditView;
import com.tencent.kinda.gen.KRegionEditViewOnRegionSelectedCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.atomic.AtomicInteger;

public class KindaRegionEditViewImpl
  extends MMKView<EditText>
  implements KRegionEditView
{
  private int REQUEST_CODE;
  private String city;
  private String country;
  private UIPageFragmentActivity.IntentHandler intentHandler;
  private KRegionEditViewOnRegionSelectedCallback mCallback;
  private Context mContext;
  private EditText mEditText;
  private String province;
  
  public KindaRegionEditViewImpl()
  {
    AppMethodBeat.i(144795);
    this.intentHandler = new UIPageFragmentActivity.IntentHandler()
    {
      public void handle(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(144794);
        if (paramAnonymousInt != -1)
        {
          AppMethodBeat.o(144794);
          return;
        }
        KindaRegionEditViewImpl.access$002(KindaRegionEditViewImpl.this, paramAnonymousIntent.getStringExtra("CountryName"));
        KindaRegionEditViewImpl.access$102(KindaRegionEditViewImpl.this, paramAnonymousIntent.getStringExtra("ProviceName"));
        KindaRegionEditViewImpl.access$202(KindaRegionEditViewImpl.this, paramAnonymousIntent.getStringExtra("CityName"));
        paramAnonymousIntent = new StringBuilder();
        if (!bo.isNullOrNil(KindaRegionEditViewImpl.this.country)) {
          paramAnonymousIntent.append(KindaRegionEditViewImpl.this.country);
        }
        if (!bo.isNullOrNil(KindaRegionEditViewImpl.this.province)) {
          paramAnonymousIntent.append(" ").append(KindaRegionEditViewImpl.this.province);
        }
        if (!bo.isNullOrNil(KindaRegionEditViewImpl.this.city)) {
          paramAnonymousIntent.append(" ").append(KindaRegionEditViewImpl.this.city);
        }
        KindaRegionEditViewImpl.this.mEditText.setText(paramAnonymousIntent.toString());
        if (KindaRegionEditViewImpl.this.mCallback != null) {
          KindaRegionEditViewImpl.this.mCallback.onRegionSelected();
        }
        AppMethodBeat.o(144794);
      }
    };
    AppMethodBeat.o(144795);
  }
  
  public EditText createView(Context paramContext)
  {
    AppMethodBeat.i(144796);
    this.mEditText = new EditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setHint(2131304969);
    this.mContext = paramContext;
    if ((this.mContext instanceof UIPageFragmentActivity))
    {
      this.REQUEST_CODE = ((UIPageFragmentActivity)this.mContext).REQUEST_CODE_COUNTER.getAndIncrement();
      ((UIPageFragmentActivity)this.mContext).registerIntentHandler(this.REQUEST_CODE, this.intentHandler);
    }
    paramContext = this.mEditText;
    AppMethodBeat.o(144796);
    return paramContext;
  }
  
  public String getCity()
  {
    return this.city;
  }
  
  public String getCountry()
  {
    return this.country;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(144798);
    boolean bool = this.mEditText.isFocused();
    AppMethodBeat.o(144798);
    return bool;
  }
  
  public String getProvince()
  {
    return this.province;
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(144797);
    if ((paramBoolean) && ((this.mContext instanceof BaseFrActivity)))
    {
      ((BaseFrActivity)this.mContext).hideTenpayKB();
      Intent localIntent = new Intent();
      localIntent.setClassName(ah.getPackageName(), ah.dsO() + ".ui.tools.MultiStageCitySelectUI");
      ((BaseFrActivity)this.mContext).startActivityForResult(localIntent, this.REQUEST_CODE);
    }
    AppMethodBeat.o(144797);
  }
  
  public void setOnRegionSelectedCallback(KRegionEditViewOnRegionSelectedCallback paramKRegionEditViewOnRegionSelectedCallback)
  {
    this.mCallback = paramKRegionEditViewOnRegionSelectedCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaRegionEditViewImpl
 * JD-Core Version:    0.7.0.1
 */
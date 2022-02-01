package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.kinda.framework.R.string;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.KRegionEditView;
import com.tencent.kinda.gen.KRegionEditViewOnRegionSelectedCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.framework.app.UIPageFragmentActivity.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class KindaRegionEditViewImpl
  extends MMKView<View>
  implements KRegionEditView
{
  private int REQUEST_CODE;
  private String cityCode;
  private String countryCode;
  private ArrayList<String> excludeAreaList;
  private UIPageFragmentActivity.a intentHandler;
  private boolean mAutoLocation;
  private KRegionEditViewOnRegionSelectedCallback mCallback;
  private LinearLayout mContainer;
  private Context mContext;
  private EditText mEditText;
  private boolean mShowDomesticCity;
  private boolean mShowSelectedLocation;
  private String provinceCode;
  
  public KindaRegionEditViewImpl()
  {
    AppMethodBeat.i(18939);
    this.mShowDomesticCity = false;
    this.mShowSelectedLocation = true;
    this.mAutoLocation = false;
    this.intentHandler = new UIPageFragmentActivity.a()
    {
      public void handle(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(18938);
        if (paramAnonymousInt != -1)
        {
          AppMethodBeat.o(18938);
          return;
        }
        KindaRegionEditViewImpl.access$002(KindaRegionEditViewImpl.this, paramAnonymousIntent.getStringExtra("Country"));
        if (!Util.isNullOrNil(paramAnonymousIntent.getStringExtra("Contact_City")))
        {
          KindaRegionEditViewImpl.access$102(KindaRegionEditViewImpl.this, paramAnonymousIntent.getStringExtra("Contact_Province"));
          KindaRegionEditViewImpl.access$202(KindaRegionEditViewImpl.this, paramAnonymousIntent.getStringExtra("Contact_City"));
        }
        for (;;)
        {
          String str1 = paramAnonymousIntent.getStringExtra("CountryName");
          String str2 = paramAnonymousIntent.getStringExtra("ProviceName");
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("CityName");
          StringBuilder localStringBuilder = new StringBuilder();
          if (!Util.isNullOrNil(str1)) {
            localStringBuilder.append(str1);
          }
          if (!Util.isNullOrNil(str2)) {
            localStringBuilder.append(" ").append(str2);
          }
          if (!Util.isNullOrNil(paramAnonymousIntent)) {
            localStringBuilder.append(" ").append(paramAnonymousIntent);
          }
          KindaRegionEditViewImpl.this.mEditText.setText(localStringBuilder.toString());
          KindaRegionEditViewImpl.this.mContainer.setContentDescription(localStringBuilder.toString());
          if (KindaRegionEditViewImpl.this.mCallback != null) {
            KindaRegionEditViewImpl.this.mCallback.onRegionSelected();
          }
          AppMethodBeat.o(18938);
          return;
          if (!Util.isNullOrNil(paramAnonymousIntent.getStringExtra("Contact_Province"))) {
            KindaRegionEditViewImpl.access$202(KindaRegionEditViewImpl.this, paramAnonymousIntent.getStringExtra("Contact_Province"));
          } else {
            KindaRegionEditViewImpl.access$202(KindaRegionEditViewImpl.this, KindaRegionEditViewImpl.this.countryCode);
          }
        }
      }
    };
    AppMethodBeat.o(18939);
  }
  
  public View createView(Context paramContext)
  {
    AppMethodBeat.i(18945);
    this.mEditText = new EditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setSingleLine(false);
    this.mEditText.setHint(R.string.wallet_card_private_info_address_hint);
    float f = MMKViewUtil.getScaleSize(paramContext);
    this.mEditText.setTextSize(0, MMKViewUtil.dpToPx(paramContext, f * 17.0F));
    this.mEditText.setPadding(0, 0, 0, 0);
    this.mContext = paramContext;
    if ((this.mContext instanceof UIPageFragmentActivity))
    {
      this.REQUEST_CODE = ((UIPageFragmentActivity)this.mContext).msM.getAndIncrement();
      UIPageFragmentActivity.a(this.REQUEST_CODE, this.intentHandler);
    }
    this.mContainer = new LayoutWrapper(paramContext, this.mEditText);
    this.mContainer.setContentDescription(paramContext.getString(R.string.wallet_card_private_info_address_hint));
    paramContext = this.mContainer;
    AppMethodBeat.o(18945);
    return paramContext;
  }
  
  public boolean getAutoLocation()
  {
    return this.mAutoLocation;
  }
  
  public String getCity()
  {
    return this.cityCode;
  }
  
  public String getCountry()
  {
    return this.countryCode;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(18944);
    boolean bool = this.mEditText.isFocused();
    AppMethodBeat.o(18944);
    return bool;
  }
  
  public String getProvince()
  {
    return this.provinceCode;
  }
  
  public boolean getShowDomesticCity()
  {
    return this.mShowDomesticCity;
  }
  
  public boolean getShowSelectedLocation()
  {
    return this.mShowSelectedLocation;
  }
  
  public boolean isUSOrCA()
  {
    AppMethodBeat.i(18942);
    if (Util.isNullOrNil(this.countryCode))
    {
      AppMethodBeat.o(18942);
      return false;
    }
    if (("US".equals(this.countryCode)) || ("CA".equals(this.countryCode)))
    {
      AppMethodBeat.o(18942);
      return true;
    }
    AppMethodBeat.o(18942);
    return false;
  }
  
  public void setAreaExcludeArray(ArrayList<String> paramArrayList)
  {
    this.excludeAreaList = paramArrayList;
  }
  
  public void setAutoLocation(boolean paramBoolean)
  {
    this.mAutoLocation = paramBoolean;
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(18943);
    if ((paramBoolean) && ((this.mContext instanceof BaseFrActivity)))
    {
      ((BaseFrActivity)this.mContext).hideTenpayKB();
      Intent localIntent = new Intent();
      localIntent.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".ui.tools.MultiStageCitySelectUI");
      localIntent.putExtra("GetAddress", true);
      localIntent.putExtra("IsNeedShowSearchBar", this.mShowDomesticCity);
      localIntent.putExtra("IsRealNameVerifyScene", this.mShowDomesticCity);
      localIntent.putExtra("ShowSelectedLocation", this.mShowSelectedLocation);
      localIntent.putExtra("IsAutoPosition", this.mAutoLocation);
      if ((this.excludeAreaList != null) && (!this.excludeAreaList.isEmpty())) {
        localIntent.putStringArrayListExtra("BlockedCountries", this.excludeAreaList);
      }
      ((BaseFrActivity)this.mContext).startActivityForResult(localIntent, this.REQUEST_CODE);
    }
    AppMethodBeat.o(18943);
  }
  
  public void setOnRegionSelectedCallback(KRegionEditViewOnRegionSelectedCallback paramKRegionEditViewOnRegionSelectedCallback)
  {
    this.mCallback = paramKRegionEditViewOnRegionSelectedCallback;
  }
  
  public void setOriginRegion(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(18941);
    this.countryCode = paramString1;
    this.provinceCode = paramString2;
    this.cityCode = paramString3;
    if (!Util.isNullOrNil(paramString4))
    {
      this.mEditText.setText(paramString4);
      this.mContainer.setContentDescription(paramString4);
    }
    AppMethodBeat.o(18941);
  }
  
  public void setShowDomesticCity(boolean paramBoolean)
  {
    this.mShowDomesticCity = paramBoolean;
  }
  
  public void setShowSelectedLocation(boolean paramBoolean)
  {
    this.mShowSelectedLocation = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaRegionEditViewImpl
 * JD-Core Version:    0.7.0.1
 */
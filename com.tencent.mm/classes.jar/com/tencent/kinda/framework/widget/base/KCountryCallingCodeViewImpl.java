package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import com.tencent.kinda.framework.app.UIPageFragmentActivity;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KCountryCallingCodeView;
import com.tencent.kinda.gen.KCountryCallingCodeViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.au.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class KCountryCallingCodeViewImpl
  extends MMKView
  implements KCountryCallingCodeView
{
  private static final String TAG = "KCountryCallingCodeView";
  private ArrayList<String> mBannedCountryIsoCodes;
  private KCountryCallingCodeViewOnSelectCallback mCallback;
  private String mCountryCode;
  private HashMap<String, b.a> mCountryCodeMap;
  private String mCountryIsoCode;
  private String mCountryName;
  private EditText mEditText;
  private boolean mHideCode;
  private UIPageFragmentActivity mUIPageFragmentActivity;
  
  private void initData(Activity paramActivity)
  {
    AppMethodBeat.i(144677);
    paramActivity = b.G(paramActivity, paramActivity.getString(2131298871));
    this.mCountryCodeMap = new HashMap();
    paramActivity = paramActivity.iterator();
    while (paramActivity.hasNext())
    {
      b.a locala = (b.a)paramActivity.next();
      if (locala != null) {
        this.mCountryCodeMap.put(locala.fHS, locala);
      }
    }
    AppMethodBeat.o(144677);
  }
  
  private void updateCountryName()
  {
    AppMethodBeat.i(144681);
    if ((this.mCountryName != null) && (this.mCountryName.length() > 0))
    {
      this.mEditText.setText(this.mCountryName);
      this.mEditText.setTextColor(this.mUIPageFragmentActivity.getResources().getColor(2131690322));
      AppMethodBeat.o(144681);
      return;
    }
    String str = this.mEditText.getHint().toString();
    if ((str == null) || (str.length() == 0))
    {
      this.mEditText.setText(2131305521);
      this.mEditText.setTextColor(this.mUIPageFragmentActivity.getResources().getColor(2131690393));
    }
    AppMethodBeat.o(144681);
  }
  
  public View createView(Context paramContext)
  {
    AppMethodBeat.i(144676);
    this.mEditText = new EditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    paramContext = KindaContext.getTopOrUIPageFragmentActivity();
    if ((paramContext instanceof UIPageFragmentActivity))
    {
      this.mUIPageFragmentActivity = ((UIPageFragmentActivity)paramContext);
      initData(paramContext);
    }
    for (;;)
    {
      paramContext = this.mEditText;
      AppMethodBeat.o(144676);
      return paramContext;
      ab.e("KCountryCallingCodeView", "没有找到UIPageFragmentActivity，却展示了KCountryCallingCodeView");
    }
  }
  
  public String getCountryCode()
  {
    return this.mCountryCode;
  }
  
  public boolean getFocus()
  {
    return false;
  }
  
  public boolean getHideCode()
  {
    return this.mHideCode;
  }
  
  public String getNationality()
  {
    return this.mCountryIsoCode;
  }
  
  public String getPlaceHolder()
  {
    AppMethodBeat.i(144682);
    String str = this.mEditText.getHint().toString();
    AppMethodBeat.o(144682);
    return str;
  }
  
  public void setCountryCode(String paramString)
  {
    AppMethodBeat.i(144679);
    if (this.mCountryCodeMap != null) {
      if ((this.mCountryCodeMap.containsKey(paramString)) && (this.mCountryCodeMap.get(paramString) != null))
      {
        b.a locala = (b.a)this.mCountryCodeMap.get(paramString);
        this.mCountryCode = paramString;
        this.mCountryName = locala.fHT;
        this.mCountryIsoCode = locala.fHR;
      }
    }
    for (;;)
    {
      updateCountryName();
      AppMethodBeat.o(144679);
      return;
      ab.e("KCountryCallingCodeView", "输入国家代码后无法找到国家名称，因为国家代码、名称映射表为空！");
    }
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(144678);
    Intent localIntent;
    if ((paramBoolean) && (this.mUIPageFragmentActivity != null))
    {
      ab.d("KCountryCallingCodeView", "click area");
      localIntent = new Intent();
      if (this.mHideCode) {
        break label86;
      }
    }
    label86:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localIntent.putExtra("CountryCodeUI_isShowCountryCode", paramBoolean);
      localIntent.putStringArrayListExtra("exclude_countries_iso", this.mBannedCountryIsoCodes);
      localIntent.setClassName(this.mUIPageFragmentActivity, "com.tencent.mm.ui.tools.CountryCodeUI");
      this.mUIPageFragmentActivity.startActivityForResult(localIntent, 65521);
      AppMethodBeat.o(144678);
      return;
    }
  }
  
  public void setHideCode(boolean paramBoolean)
  {
    this.mHideCode = paramBoolean;
  }
  
  public void setNationality(String paramString)
  {
    AppMethodBeat.i(144684);
    if (this.mCountryCodeMap != null)
    {
      Iterator localIterator = this.mCountryCodeMap.values().iterator();
      while (localIterator.hasNext())
      {
        b.a locala = (b.a)localIterator.next();
        if (locala.fHR.equals(paramString))
        {
          this.mCountryCode = locala.fHS;
          this.mCountryName = locala.fHT;
          this.mCountryIsoCode = locala.fHR;
        }
      }
    }
    updateCountryName();
    AppMethodBeat.o(144684);
  }
  
  public void setNationalityExcludeArray(ArrayList<String> paramArrayList)
  {
    this.mBannedCountryIsoCodes = paramArrayList;
  }
  
  public void setOnSelectCallback(KCountryCallingCodeViewOnSelectCallback paramKCountryCallingCodeViewOnSelectCallback)
  {
    AppMethodBeat.i(144680);
    this.mCallback = paramKCountryCallingCodeViewOnSelectCallback;
    paramKCountryCallingCodeViewOnSelectCallback = new KCountryCallingCodeViewImpl.1(this);
    if (this.mUIPageFragmentActivity != null) {
      this.mUIPageFragmentActivity.registerIntentHandler(65521, paramKCountryCallingCodeViewOnSelectCallback);
    }
    AppMethodBeat.o(144680);
  }
  
  public void setPlaceHolder(String paramString)
  {
    AppMethodBeat.i(144683);
    this.mEditText.setHint(paramString);
    AppMethodBeat.o(144683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KCountryCallingCodeViewImpl
 * JD-Core Version:    0.7.0.1
 */
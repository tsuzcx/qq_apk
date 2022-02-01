package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KCountryCallingCodeView;
import com.tencent.kinda.gen.KCountryCallingCodeViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.framework.app.UIPageFragmentActivity.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private String[] mBannedCountryIsoCodes;
  private KCountryCallingCodeViewOnSelectCallback mCallback;
  private String mCountryCode;
  private HashMap<String, b.a> mCountryCodeMap;
  private String mCountryIsoCode;
  private String mCountryName;
  private EditText mEditText;
  private boolean mHideCode;
  private HashMap<String, b.a> mISOCountryCodeMap;
  private UIPageFragmentActivity mUIPageFragmentActivity;
  
  private void initData(Activity paramActivity)
  {
    AppMethodBeat.i(18799);
    paramActivity = b.Gt(paramActivity.getString(2131757950));
    this.mCountryCodeMap = new HashMap();
    this.mISOCountryCodeMap = new HashMap();
    paramActivity = paramActivity.iterator();
    while (paramActivity.hasNext())
    {
      b.a locala = (b.a)paramActivity.next();
      if (locala != null)
      {
        this.mCountryCodeMap.put(locala.ihd, locala);
        this.mISOCountryCodeMap.put(locala.ihc, locala);
      }
    }
    AppMethodBeat.o(18799);
  }
  
  private void updateCountryName()
  {
    AppMethodBeat.i(18803);
    if ((this.mCountryName != null) && (this.mCountryName.length() > 0))
    {
      this.mEditText.setText(this.mCountryName);
      this.mEditText.setTextColor(this.mUIPageFragmentActivity.getResources().getColor(2131100711));
      AppMethodBeat.o(18803);
      return;
    }
    String str = null;
    if (this.mEditText.getHint() != null) {
      str = this.mEditText.getHint().toString();
    }
    if ((str == null) || (str.length() == 0))
    {
      this.mEditText.setText(2131765736);
      this.mEditText.setTextColor(this.mUIPageFragmentActivity.getResources().getColor(2131100800));
    }
    AppMethodBeat.o(18803);
  }
  
  public View createView(Context paramContext)
  {
    AppMethodBeat.i(18798);
    this.mEditText = new EditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setTextSize(16.0F);
    this.mEditText.setPadding(0, 0, 0, 0);
    paramContext = KindaContext.getTopOrUIPageFragmentActivity();
    if ((paramContext instanceof UIPageFragmentActivity))
    {
      this.mUIPageFragmentActivity = ((UIPageFragmentActivity)paramContext);
      initData(paramContext);
    }
    for (;;)
    {
      paramContext = this.mEditText;
      AppMethodBeat.o(18798);
      return paramContext;
      ae.e("KCountryCallingCodeView", "没有找到UIPageFragmentActivity，却展示了KCountryCallingCodeView");
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
    AppMethodBeat.i(18804);
    String str = this.mEditText.getHint().toString();
    AppMethodBeat.o(18804);
    return str;
  }
  
  public void setCountryCode(String paramString)
  {
    AppMethodBeat.i(18801);
    if (this.mCountryCodeMap != null)
    {
      String str = paramString;
      if (paramString.contains("+")) {
        str = paramString.substring(1);
      }
      if (((str.equals("1")) && (this.mCountryIsoCode.equals("CA"))) || ((str.equals("1")) && (this.mCountryIsoCode.equals("US"))))
      {
        AppMethodBeat.o(18801);
        return;
      }
      if ((this.mCountryCodeMap.containsKey(str)) && (this.mCountryCodeMap.get(str) != null))
      {
        paramString = (b.a)this.mCountryCodeMap.get(str);
        this.mCountryCode = str;
        this.mCountryName = paramString.ihe;
        this.mCountryIsoCode = paramString.ihc;
      }
    }
    for (;;)
    {
      updateCountryName();
      AppMethodBeat.o(18801);
      return;
      this.mCountryName = "";
      continue;
      ae.e("KCountryCallingCodeView", "输入国家代码后无法找到国家名称，因为国家代码、名称映射表为空！");
    }
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(18800);
    Intent localIntent;
    if ((paramBoolean) && (this.mUIPageFragmentActivity != null))
    {
      ae.d("KCountryCallingCodeView", "click area");
      localIntent = new Intent();
      if (this.mHideCode) {
        break label92;
      }
    }
    label92:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localIntent.putExtra("CountryCodeUI_isShowCountryCode", paramBoolean);
      localIntent.putExtra("exclude_countries_iso", this.mBannedCountryIsoCodes);
      localIntent.setClassName(this.mUIPageFragmentActivity, "com.tencent.mm.ui.tools.CountryCodeUI");
      this.mUIPageFragmentActivity.startActivityForResult(localIntent, 65521);
      AppMethodBeat.o(18800);
      return;
    }
  }
  
  public void setHideCode(boolean paramBoolean)
  {
    this.mHideCode = paramBoolean;
  }
  
  public void setNationality(String paramString)
  {
    AppMethodBeat.i(18806);
    if (this.mISOCountryCodeMap != null)
    {
      Iterator localIterator = this.mISOCountryCodeMap.values().iterator();
      while (localIterator.hasNext())
      {
        b.a locala = (b.a)localIterator.next();
        if (locala.ihc.equals(paramString))
        {
          this.mCountryCode = locala.ihd;
          this.mCountryName = locala.ihe;
          this.mCountryIsoCode = locala.ihc;
        }
      }
    }
    updateCountryName();
    AppMethodBeat.o(18806);
  }
  
  public void setNationalityExcludeArray(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(193168);
    if (paramArrayList != null) {
      this.mBannedCountryIsoCodes = bu.hs(paramArrayList);
    }
    AppMethodBeat.o(193168);
  }
  
  public void setOnSelectCallback(KCountryCallingCodeViewOnSelectCallback paramKCountryCallingCodeViewOnSelectCallback)
  {
    AppMethodBeat.i(18802);
    this.mCallback = paramKCountryCallingCodeViewOnSelectCallback;
    paramKCountryCallingCodeViewOnSelectCallback = new UIPageFragmentActivity.a()
    {
      public void handle(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(18797);
        KCountryCallingCodeViewImpl.access$002(KCountryCallingCodeViewImpl.this, paramAnonymousIntent.getStringExtra("country_name"));
        KCountryCallingCodeViewImpl.access$102(KCountryCallingCodeViewImpl.this, paramAnonymousIntent.getStringExtra("couttry_code"));
        KCountryCallingCodeViewImpl.access$202(KCountryCallingCodeViewImpl.this, paramAnonymousIntent.getStringExtra("iso_code"));
        ae.i("KCountryCallingCodeView", "handle back mCountryName:%s.mCountryCode:%s mCountryIsoCode:%s", new Object[] { KCountryCallingCodeViewImpl.this.mCountryName, KCountryCallingCodeViewImpl.this.mCountryCode, KCountryCallingCodeViewImpl.this.mCountryIsoCode });
        if (!bu.isNullOrNil(KCountryCallingCodeViewImpl.this.mCountryName))
        {
          KCountryCallingCodeViewImpl.access$300(KCountryCallingCodeViewImpl.this);
          KCountryCallingCodeViewImpl.this.mCallback.onSelect(KCountryCallingCodeViewImpl.this.mCountryCode, KCountryCallingCodeViewImpl.this.mCountryIsoCode);
        }
        AppMethodBeat.o(18797);
      }
    };
    if (this.mUIPageFragmentActivity != null) {
      UIPageFragmentActivity.a(65521, paramKCountryCallingCodeViewOnSelectCallback);
    }
    AppMethodBeat.o(18802);
  }
  
  public void setPlaceHolder(String paramString)
  {
    AppMethodBeat.i(18805);
    this.mEditText.setHint(paramString);
    AppMethodBeat.o(18805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KCountryCallingCodeViewImpl
 * JD-Core Version:    0.7.0.1
 */
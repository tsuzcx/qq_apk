package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;

public class LanguagePreference
  extends Preference
{
  public LanguagePreference.a fmi;
  
  public LanguagePreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LanguagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LanguagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(q.g.mm_preference);
  }
  
  public final void a(LanguagePreference.a parama)
  {
    if ((parama == null) || (bk.bl(parama.fml)))
    {
      y.e("MicroMsg.LanguagePreference", "setInfo info error");
      return;
    }
    this.fmi = parama;
    setKey(parama.fml);
  }
  
  protected final void onBindView(View paramView)
  {
    int j = 1;
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(q.f.languagename);
    paramView = (CheckBox)paramView.findViewById(q.f.state_icon);
    int i;
    if (localTextView != null)
    {
      i = 1;
      if (paramView == null) {
        break label76;
      }
    }
    for (;;)
    {
      if ((j & i) != 0)
      {
        localTextView.setText(this.fmi.fmj);
        paramView.setChecked(this.fmi.fmm);
      }
      return;
      i = 0;
      break;
      label76:
      j = 0;
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(q.f.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(q.g.mm_preference_content_language, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LanguagePreference
 * JD-Core Version:    0.7.0.1
 */
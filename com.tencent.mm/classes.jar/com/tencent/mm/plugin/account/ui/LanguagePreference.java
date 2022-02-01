package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class LanguagePreference
  extends Preference
{
  public a qay;
  
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
    AppMethodBeat.i(128055);
    setLayoutResource(r.g.mm_preference);
    AppMethodBeat.o(128055);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(128056);
    if ((parama == null) || (Util.isNullOrNil(parama.qaB)))
    {
      Log.e("MicroMsg.LanguagePreference", "setInfo info error");
      AppMethodBeat.o(128056);
      return;
    }
    this.qay = parama;
    setKey(parama.qaB);
    AppMethodBeat.o(128056);
  }
  
  public final void onBindView(View paramView)
  {
    int j = 1;
    AppMethodBeat.i(128058);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(r.f.languagename);
    paramView = (WeImageView)paramView.findViewById(r.f.state_icon);
    if (localTextView != null)
    {
      i = 1;
      if (paramView == null) {
        break label98;
      }
      label46:
      if ((j & i) != 0)
      {
        localTextView.setText(this.qay.qaz);
        if (!this.qay.isSelected) {
          break label103;
        }
      }
    }
    label98:
    label103:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      aBq(8);
      AppMethodBeat.o(128058);
      return;
      i = 0;
      break;
      j = 0;
      break label46;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(128057);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(r.f.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(r.g.mm_preference_content_language, localViewGroup);
    AppMethodBeat.o(128057);
    return paramViewGroup;
  }
  
  public static final class a
  {
    public boolean isSelected;
    private String qaA;
    public String qaB;
    public String qaz;
    
    public a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      this.qaz = paramString1;
      this.qaA = paramString2;
      this.qaB = paramString3;
      this.isSelected = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LanguagePreference
 * JD-Core Version:    0.7.0.1
 */
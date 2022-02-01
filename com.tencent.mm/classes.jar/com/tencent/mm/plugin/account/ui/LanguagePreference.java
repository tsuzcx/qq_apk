package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class LanguagePreference
  extends Preference
{
  public a iRd;
  
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
    setLayoutResource(2131494804);
    AppMethodBeat.o(128055);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(128056);
    if ((parama == null) || (bs.isNullOrNil(parama.iRg)))
    {
      ac.e("MicroMsg.LanguagePreference", "setInfo info error");
      AppMethodBeat.o(128056);
      return;
    }
    this.iRd = parama;
    setKey(parama.iRg);
    AppMethodBeat.o(128056);
  }
  
  public final void onBindView(View paramView)
  {
    int j = 1;
    AppMethodBeat.i(128058);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(2131301307);
    paramView = (WeImageView)paramView.findViewById(2131305186);
    if (localTextView != null)
    {
      i = 1;
      if (paramView == null) {
        break label96;
      }
      label44:
      if ((j & i) != 0)
      {
        localTextView.setText(this.iRd.iRe);
        if (!this.iRd.isSelected) {
          break label101;
        }
      }
    }
    label96:
    label101:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      aam(8);
      AppMethodBeat.o(128058);
      return;
      i = 0;
      break;
      j = 0;
      break label44;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(128057);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494834, localViewGroup);
    AppMethodBeat.o(128057);
    return paramViewGroup;
  }
  
  public static final class a
  {
    String iRe;
    private String iRf;
    public String iRg;
    public boolean isSelected;
    
    public a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      this.iRe = paramString1;
      this.iRf = paramString2;
      this.iRg = paramString3;
      this.isSelected = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LanguagePreference
 * JD-Core Version:    0.7.0.1
 */
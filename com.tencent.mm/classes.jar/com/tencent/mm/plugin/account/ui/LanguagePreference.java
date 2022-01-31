package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public class LanguagePreference
  extends Preference
{
  public LanguagePreference.a gDC;
  
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
    AppMethodBeat.i(124905);
    setLayoutResource(2130970179);
    AppMethodBeat.o(124905);
  }
  
  public final void a(LanguagePreference.a parama)
  {
    AppMethodBeat.i(124906);
    if ((parama == null) || (bo.isNullOrNil(parama.gDF)))
    {
      ab.e("MicroMsg.LanguagePreference", "setInfo info error");
      AppMethodBeat.o(124906);
      return;
    }
    this.gDC = parama;
    setKey(parama.gDF);
    AppMethodBeat.o(124906);
  }
  
  public final void onBindView(View paramView)
  {
    int j = 1;
    AppMethodBeat.i(124908);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(2131821815);
    paramView = (CheckBox)paramView.findViewById(2131824746);
    int i;
    if (localTextView != null)
    {
      i = 1;
      if (paramView == null) {
        break label90;
      }
    }
    for (;;)
    {
      if ((j & i) != 0)
      {
        localTextView.setText(this.gDC.gDD);
        paramView.setChecked(this.gDC.gDG);
      }
      OW(8);
      AppMethodBeat.o(124908);
      return;
      i = 0;
      break;
      label90:
      j = 0;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(124907);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2130970207, localViewGroup);
    AppMethodBeat.o(124907);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LanguagePreference
 * JD-Core Version:    0.7.0.1
 */
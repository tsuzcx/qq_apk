package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class CdnImageIconPreference
  extends IconPreference
{
  String iconUrl;
  private CdnImageView oyh;
  
  public CdnImageIconPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public CdnImageIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CdnImageIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(43132);
    super.onBindView(paramView);
    this.oyh = ((CdnImageView)paramView.findViewById(2131822243));
    if (!bo.isNullOrNil(this.iconUrl))
    {
      this.oyh.setUseSdcardCache(true);
      this.oyh.setUrl(this.iconUrl);
      this.oyh.setVisibility(0);
    }
    AppMethodBeat.o(43132);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(43131);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2130969016, localViewGroup);
    AppMethodBeat.o(43131);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.CdnImageIconPreference
 * JD-Core Version:    0.7.0.1
 */
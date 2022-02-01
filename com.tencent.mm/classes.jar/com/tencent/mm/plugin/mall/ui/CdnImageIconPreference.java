package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class CdnImageIconPreference
  extends IconPreference
{
  String iconUrl;
  private CdnImageView tsI;
  
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
    AppMethodBeat.i(66029);
    super.onBindView(paramView);
    this.tsI = ((CdnImageView)paramView.findViewById(2131300943));
    if (!bt.isNullOrNil(this.iconUrl))
    {
      this.tsI.setUseSdcardCache(true);
      this.tsI.setUrl(this.iconUrl);
      this.tsI.setVisibility(0);
    }
    AppMethodBeat.o(66029);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66028);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131493367, localViewGroup);
    AppMethodBeat.o(66028);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.CdnImageIconPreference
 * JD-Core Version:    0.7.0.1
 */
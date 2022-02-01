package com.tencent.mm.chatroom.ui.story;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import java.util.ArrayList;

public class StoryLoadIconPreference
  extends Preference
{
  private StoryAvatarDotsView fXc;
  private b.h fXd;
  private int fXe;
  private int fXf;
  private int fXg;
  private int fXh;
  private int fXi;
  private ArrayList<String> fXj;
  private Context mContext;
  private View mView;
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(13018);
    this.mView = null;
    this.fXh = -1;
    this.fXi = -1;
    this.fXj = new ArrayList();
    bX(paramContext);
    AppMethodBeat.o(13018);
  }
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(13019);
    this.mView = null;
    this.fXh = -1;
    this.fXi = -1;
    this.fXj = new ArrayList();
    bX(paramContext);
    AppMethodBeat.o(13019);
  }
  
  private void bX(Context paramContext)
  {
    AppMethodBeat.i(13020);
    setLayoutResource(2131494804);
    this.mContext = paramContext;
    AppMethodBeat.o(13020);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(13022);
    super.onBindView(paramView);
    this.fXe = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 21);
    this.fXg = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 2);
    this.fXf = com.tencent.mm.cb.a.fromDPToPix(this.mContext, this.fXe);
    this.fXh = this.mContext.getResources().getColor(2131100498);
    this.fXc = ((StoryAvatarDotsView)paramView.findViewById(2131305458));
    this.fXc.setIconSize(this.fXe + this.fXg * 2);
    this.fXc.setIconGap(this.fXf / 2);
    if (this.fXc != null)
    {
      if (this.fXj.size() > 0)
      {
        this.fXc.setVisibility(0);
        this.fXc.setIconLayerCount(Math.min(this.fXj.size(), 3));
        if (this.fXd == null) {
          this.fXd = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.fXe, this.fXg, this.fXh);
        }
        int i = 0;
        while (i < this.fXc.getChildCount())
        {
          a.b.a(this.fXc.vV(i), (String)this.fXj.get(i), 0.5F, false);
          i += 1;
        }
        AppMethodBeat.o(13022);
        return;
      }
      this.fXc.setVisibility(8);
    }
    AppMethodBeat.o(13022);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(13021);
    if (this.mView == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      View.inflate(this.mContext, 2131495706, localViewGroup);
      this.mView = paramViewGroup;
    }
    paramViewGroup = this.mView;
    AppMethodBeat.o(13021);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.story.StoryLoadIconPreference
 * JD-Core Version:    0.7.0.1
 */
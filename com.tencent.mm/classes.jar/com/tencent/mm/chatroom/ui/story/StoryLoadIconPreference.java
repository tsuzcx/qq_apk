package com.tencent.mm.chatroom.ui.story;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.a.e;
import com.tencent.mm.chatroom.ui.a.f;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import java.util.ArrayList;

public class StoryLoadIconPreference
  extends Preference
{
  private StoryAvatarDotsView lPm;
  private b.h lPn;
  private int lPo;
  private int lPp;
  private int lPq;
  private int lPr;
  private int lPs;
  private ArrayList<String> lPt;
  private Context mContext;
  private View mView;
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(13018);
    this.mView = null;
    this.lPr = -1;
    this.lPs = -1;
    this.lPt = new ArrayList();
    dc(paramContext);
    AppMethodBeat.o(13018);
  }
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(13019);
    this.mView = null;
    this.lPr = -1;
    this.lPs = -1;
    this.lPt = new ArrayList();
    dc(paramContext);
    AppMethodBeat.o(13019);
  }
  
  private void dc(Context paramContext)
  {
    AppMethodBeat.i(13020);
    setLayoutResource(a.f.mm_preference);
    this.mContext = paramContext;
    AppMethodBeat.o(13020);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(13022);
    super.onBindView(paramView);
    this.lPo = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 21);
    this.lPq = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 2);
    this.lPp = com.tencent.mm.cd.a.fromDPToPix(this.mContext, this.lPo);
    this.lPr = this.mContext.getResources().getColor(com.tencent.mm.chatroom.ui.a.b.icon_border_color);
    this.lPm = ((StoryAvatarDotsView)paramView.findViewById(a.e.lFB));
    this.lPm.setIconSize(this.lPo + this.lPq * 2);
    this.lPm.setIconGap(this.lPp / 2);
    if (this.lPm != null)
    {
      if (this.lPt.size() > 0)
      {
        this.lPm.setVisibility(0);
        this.lPm.setIconLayerCount(Math.min(this.lPt.size(), 3));
        if (this.lPn == null) {
          this.lPn = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.lPo, this.lPq, this.lPr);
        }
        int i = 0;
        while (i < this.lPm.getChildCount())
        {
          com.tencent.mm.pluginsdk.ui.a.b.a(this.lPm.DS(i), (String)this.lPt.get(i), 0.5F, false);
          i += 1;
        }
        AppMethodBeat.o(13022);
        return;
      }
      this.lPm.setVisibility(8);
    }
    AppMethodBeat.o(13022);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(13021);
    if (this.mView == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.e.content);
      localViewGroup.removeAllViews();
      View.inflate(this.mContext, a.f.lGD, localViewGroup);
      this.mView = paramViewGroup;
    }
    paramViewGroup = this.mView;
    AppMethodBeat.o(13021);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.story.StoryLoadIconPreference
 * JD-Core Version:    0.7.0.1
 */
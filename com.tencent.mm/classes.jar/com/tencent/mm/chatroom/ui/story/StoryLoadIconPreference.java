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
  private StoryAvatarDotsView jmo;
  private b.h jmp;
  private int jmq;
  private int jmr;
  private int jms;
  private int jmt;
  private int jmu;
  private ArrayList<String> jmv;
  private Context mContext;
  private View mView;
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(13018);
    this.mView = null;
    this.jmt = -1;
    this.jmu = -1;
    this.jmv = new ArrayList();
    co(paramContext);
    AppMethodBeat.o(13018);
  }
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(13019);
    this.mView = null;
    this.jmt = -1;
    this.jmu = -1;
    this.jmv = new ArrayList();
    co(paramContext);
    AppMethodBeat.o(13019);
  }
  
  private void co(Context paramContext)
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
    this.jmq = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 21);
    this.jms = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 2);
    this.jmr = com.tencent.mm.ci.a.fromDPToPix(this.mContext, this.jmq);
    this.jmt = this.mContext.getResources().getColor(com.tencent.mm.chatroom.ui.a.b.icon_border_color);
    this.jmo = ((StoryAvatarDotsView)paramView.findViewById(a.e.jdt));
    this.jmo.setIconSize(this.jmq + this.jms * 2);
    this.jmo.setIconGap(this.jmr / 2);
    if (this.jmo != null)
    {
      if (this.jmv.size() > 0)
      {
        this.jmo.setVisibility(0);
        this.jmo.setIconLayerCount(Math.min(this.jmv.size(), 3));
        if (this.jmp == null) {
          this.jmp = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.jmq, this.jms, this.jmt);
        }
        int i = 0;
        while (i < this.jmo.getChildCount())
        {
          com.tencent.mm.pluginsdk.ui.a.b.a(this.jmo.Dt(i), (String)this.jmv.get(i), 0.5F, false);
          i += 1;
        }
        AppMethodBeat.o(13022);
        return;
      }
      this.jmo.setVisibility(8);
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
      View.inflate(this.mContext, a.f.jes, localViewGroup);
      this.mView = paramViewGroup;
    }
    paramViewGroup = this.mView;
    AppMethodBeat.o(13021);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.story.StoryLoadIconPreference
 * JD-Core Version:    0.7.0.1
 */
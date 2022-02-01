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
  private StoryAvatarDotsView fUW;
  private b.h fUX;
  private int fUY;
  private int fUZ;
  private int fVa;
  private int fVb;
  private int fVc;
  private ArrayList<String> fVd;
  private Context mContext;
  private View mView;
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(13018);
    this.mView = null;
    this.fVb = -1;
    this.fVc = -1;
    this.fVd = new ArrayList();
    bV(paramContext);
    AppMethodBeat.o(13018);
  }
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(13019);
    this.mView = null;
    this.fVb = -1;
    this.fVc = -1;
    this.fVd = new ArrayList();
    bV(paramContext);
    AppMethodBeat.o(13019);
  }
  
  private void bV(Context paramContext)
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
    this.fUY = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 21);
    this.fVa = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 2);
    this.fUZ = com.tencent.mm.cc.a.fromDPToPix(this.mContext, this.fUY);
    this.fVb = this.mContext.getResources().getColor(2131100498);
    this.fUW = ((StoryAvatarDotsView)paramView.findViewById(2131305458));
    this.fUW.setIconSize(this.fUY + this.fVa * 2);
    this.fUW.setIconGap(this.fUZ / 2);
    if (this.fUW != null)
    {
      if (this.fVd.size() > 0)
      {
        this.fUW.setVisibility(0);
        this.fUW.setIconLayerCount(Math.min(this.fVd.size(), 3));
        if (this.fUX == null) {
          this.fUX = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.fUY, this.fVa, this.fVb);
        }
        int i = 0;
        while (i < this.fUW.getChildCount())
        {
          a.b.a(this.fUW.vQ(i), (String)this.fVd.get(i), 0.5F, false);
          i += 1;
        }
        AppMethodBeat.o(13022);
        return;
      }
      this.fUW.setVisibility(8);
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
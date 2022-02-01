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
  private StoryAvatarDotsView fyc;
  private b.h fyd;
  private int fye;
  private int fyf;
  private int fyg;
  private int fyh;
  private int fyi;
  private ArrayList<String> fyj;
  private Context mContext;
  private View mView;
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(13018);
    this.mView = null;
    this.fyh = -1;
    this.fyi = -1;
    this.fyj = new ArrayList();
    bU(paramContext);
    AppMethodBeat.o(13018);
  }
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(13019);
    this.mView = null;
    this.fyh = -1;
    this.fyi = -1;
    this.fyj = new ArrayList();
    bU(paramContext);
    AppMethodBeat.o(13019);
  }
  
  private void bU(Context paramContext)
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
    this.fye = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 21);
    this.fyg = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 2);
    this.fyf = com.tencent.mm.cd.a.fromDPToPix(this.mContext, this.fye);
    this.fyh = this.mContext.getResources().getColor(2131100498);
    this.fyc = ((StoryAvatarDotsView)paramView.findViewById(2131305458));
    this.fyc.setIconSize(this.fye + this.fyg * 2);
    this.fyc.setIconGap(this.fyf / 2);
    if (this.fyc != null)
    {
      if (this.fyj.size() > 0)
      {
        this.fyc.setVisibility(0);
        this.fyc.setIconLayerCount(Math.min(this.fyj.size(), 3));
        if (this.fyd == null) {
          this.fyd = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.fye, this.fyg, this.fyh);
        }
        int i = 0;
        while (i < this.fyc.getChildCount())
        {
          a.b.a(this.fyc.us(i), (String)this.fyj.get(i), 0.5F, false);
          i += 1;
        }
        AppMethodBeat.o(13022);
        return;
      }
      this.fyc.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.story.StoryLoadIconPreference
 * JD-Core Version:    0.7.0.1
 */
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
  private StoryAvatarDotsView fBJ;
  private b.h fBK;
  private int fBL;
  private int fBM;
  private int fBN;
  private int fBO;
  private int fBP;
  private ArrayList<String> fBQ;
  private Context mContext;
  private View mView;
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(13018);
    this.mView = null;
    this.fBO = -1;
    this.fBP = -1;
    this.fBQ = new ArrayList();
    bX(paramContext);
    AppMethodBeat.o(13018);
  }
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(13019);
    this.mView = null;
    this.fBO = -1;
    this.fBP = -1;
    this.fBQ = new ArrayList();
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
    this.fBL = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 21);
    this.fBN = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 2);
    this.fBM = com.tencent.mm.cc.a.fromDPToPix(this.mContext, this.fBL);
    this.fBO = this.mContext.getResources().getColor(2131100498);
    this.fBJ = ((StoryAvatarDotsView)paramView.findViewById(2131305458));
    this.fBJ.setIconSize(this.fBL + this.fBN * 2);
    this.fBJ.setIconGap(this.fBM / 2);
    if (this.fBJ != null)
    {
      if (this.fBQ.size() > 0)
      {
        this.fBJ.setVisibility(0);
        this.fBJ.setIconLayerCount(Math.min(this.fBQ.size(), 3));
        if (this.fBK == null) {
          this.fBK = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.fBL, this.fBN, this.fBO);
        }
        int i = 0;
        while (i < this.fBJ.getChildCount())
        {
          a.b.a(this.fBJ.vk(i), (String)this.fBQ.get(i), 0.5F, false);
          i += 1;
        }
        AppMethodBeat.o(13022);
        return;
      }
      this.fBJ.setVisibility(8);
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
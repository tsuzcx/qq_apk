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
  private StoryAvatarDotsView gCi;
  private b.h gCj;
  private int gCk;
  private int gCl;
  private int gCm;
  private int gCn;
  private int gCo;
  private ArrayList<String> gCp;
  private Context mContext;
  private View mView;
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(13018);
    this.mView = null;
    this.gCn = -1;
    this.gCo = -1;
    this.gCp = new ArrayList();
    cs(paramContext);
    AppMethodBeat.o(13018);
  }
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(13019);
    this.mView = null;
    this.gCn = -1;
    this.gCo = -1;
    this.gCp = new ArrayList();
    cs(paramContext);
    AppMethodBeat.o(13019);
  }
  
  private void cs(Context paramContext)
  {
    AppMethodBeat.i(13020);
    setLayoutResource(2131495538);
    this.mContext = paramContext;
    AppMethodBeat.o(13020);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(13022);
    super.onBindView(paramView);
    this.gCk = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 21);
    this.gCm = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 2);
    this.gCl = com.tencent.mm.cb.a.fromDPToPix(this.mContext, this.gCk);
    this.gCn = this.mContext.getResources().getColor(2131100633);
    this.gCi = ((StoryAvatarDotsView)paramView.findViewById(2131308664));
    this.gCi.setIconSize(this.gCk + this.gCm * 2);
    this.gCi.setIconGap(this.gCl / 2);
    if (this.gCi != null)
    {
      if (this.gCp.size() > 0)
      {
        this.gCi.setVisibility(0);
        this.gCi.setIconLayerCount(Math.min(this.gCp.size(), 3));
        if (this.gCj == null) {
          this.gCj = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.gCk, this.gCm, this.gCn);
        }
        int i = 0;
        while (i < this.gCi.getChildCount())
        {
          a.b.a(this.gCi.zK(i), (String)this.gCp.get(i), 0.5F, false);
          i += 1;
        }
        AppMethodBeat.o(13022);
        return;
      }
      this.gCi.setVisibility(8);
    }
    AppMethodBeat.o(13022);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(13021);
    if (this.mView == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
      localViewGroup.removeAllViews();
      View.inflate(this.mContext, 2131496611, localViewGroup);
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
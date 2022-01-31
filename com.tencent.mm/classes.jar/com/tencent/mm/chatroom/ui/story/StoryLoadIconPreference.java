package com.tencent.mm.chatroom.ui.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import java.util.ArrayList;

public class StoryLoadIconPreference
  extends Preference
{
  private StoryAvatarDotsView ell;
  private b.f elm;
  private int eln;
  private int elo;
  private int elp;
  private final int elq;
  private int elr;
  private ArrayList<String> els;
  private Context mContext;
  private View mView;
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(104476);
    this.mView = null;
    this.elq = -1;
    this.elr = -1;
    this.els = new ArrayList();
    bF(paramContext);
    AppMethodBeat.o(104476);
  }
  
  public StoryLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104477);
    this.mView = null;
    this.elq = -1;
    this.elr = -1;
    this.els = new ArrayList();
    bF(paramContext);
    AppMethodBeat.o(104477);
  }
  
  private void bF(Context paramContext)
  {
    AppMethodBeat.i(104478);
    setLayoutResource(2130970179);
    this.mContext = paramContext;
    AppMethodBeat.o(104478);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(104480);
    super.onBindView(paramView);
    this.eln = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 21);
    this.elp = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 2);
    this.elo = com.tencent.mm.cb.a.fromDPToPix(this.mContext, this.eln);
    this.ell = ((StoryAvatarDotsView)paramView.findViewById(2131828436));
    this.ell.setIconSize(this.eln + this.elp * 2);
    this.ell.setIconGap(this.elo / 2);
    if (this.ell != null)
    {
      if (this.els.size() > 0)
      {
        this.ell.setVisibility(0);
        this.ell.setIconLayerCount(Math.min(this.els.size(), 3));
        if (this.elm == null) {
          this.elm = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.eln, this.elp);
        }
        int i = 0;
        while (i < this.ell.getChildCount())
        {
          a.b.a(this.ell.pU(i), (String)this.els.get(i), 0.5F, false);
          i += 1;
        }
        AppMethodBeat.o(104480);
        return;
      }
      this.ell.setVisibility(8);
    }
    AppMethodBeat.o(104480);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(104479);
    if (this.mView == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
      localViewGroup.removeAllViews();
      View.inflate(this.mContext, 2130970966, localViewGroup);
      this.mView = paramViewGroup;
    }
    paramViewGroup = this.mView;
    AppMethodBeat.o(104479);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.story.StoryLoadIconPreference
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.replay.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.model.r;
import com.tencent.mm.live.model.r.a;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.replay.FinderLiveReplayPluginLayout;
import com.tencent.mm.plugin.finder.replay.FinderLiveThumbPlayerProxy;
import com.tencent.mm.plugin.finder.replay.widget.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayerSeekbarPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "seekBar", "Landroid/widget/SeekBar;", "seekBarBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "seekBarCurTimeYv", "Landroid/widget/TextView;", "seekBarSumTimeTv", "canClearScreen", "", "formatString", "number", "", "onClick", "", "v", "Landroid/view/View;", "onVideoEnd", "onVideoPause", "onVideoPlay", "updatePlayProgress", "offset", "total", "updateTextProgress", "visibleInCurrentLiveMode", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.plugin.finder.live.plugin.b
  implements View.OnClickListener
{
  private final WeImageView Fmm;
  private final TextView Fmn;
  private final TextView Fmo;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  private final SeekBar uMM;
  
  public e(final ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(332917);
    this.nfT = paramb;
    this.TAG = "FinderLiveReplayerSeekbarPlugin";
    paramb = paramViewGroup.findViewById(p.e.Can);
    s.s(paramb, "root.findViewById(R.id.replay_seek_bar)");
    this.uMM = ((SeekBar)paramb);
    paramb = paramViewGroup.findViewById(p.e.Cao);
    s.s(paramb, "root.findViewById(R.id.replay_seek_bar_action_btn)");
    this.Fmm = ((WeImageView)paramb);
    paramb = paramViewGroup.findViewById(p.e.Cap);
    s.s(paramb, "root.findViewById(R.id.replay_seek_bar_cur_time)");
    this.Fmn = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.Caq);
    s.s(paramb, "root.findViewById(R.id.replay_seek_bar_sum_time)");
    this.Fmo = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.Car).getLayoutParams();
    if ((paramb instanceof ViewGroup.MarginLayoutParams))
    {
      paramb = (ViewGroup.MarginLayoutParams)paramb;
      if (paramb != null) {
        paramb.bottomMargin = (paramViewGroup.getContext().getResources().getDimensionPixelOffset(p.c.Edge_2A) + bf.bk(MMApplicationContext.getContext()));
      }
      if (Build.VERSION.SDK_INT >= 29)
      {
        paramb = this.uMM;
        if (!isLandscape()) {
          break label263;
        }
      }
    }
    label263:
    for (int i = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_0_5_A);; i = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_0_25A))
    {
      paramb.setMaxHeight(i);
      this.uMM.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new SeekBar.OnSeekBarChangeListener()
      {
        public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(332928);
          Log.i(e.a(this.Fmp), "onProgressChanged progress:" + paramAnonymousInt + " fromUser:" + paramAnonymousBoolean);
          if ((paramAnonymousBoolean) && (((com.tencent.mm.plugin.finder.replay.viewmodel.c)this.Fmp.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).FmQ > 0)) {
            e.b(this.Fmp);
          }
          AppMethodBeat.o(332928);
        }
        
        public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
          AppMethodBeat.i(332933);
          Log.i(e.a(this.Fmp), "onStartTrackingTouch");
          paramAnonymousSeekBar = (d)this.Fmp.getPlugin(d.class);
          if (paramAnonymousSeekBar != null) {
            paramAnonymousSeekBar.dSW();
          }
          AppMethodBeat.o(332933);
        }
        
        public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
          AppMethodBeat.i(332943);
          Log.i(e.a(this.Fmp), "onStopTrackingTouch");
          if ((((com.tencent.mm.plugin.finder.replay.viewmodel.c)this.Fmp.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).FmQ > 0) && (paramAnonymousSeekBar != null))
          {
            e locale = this.Fmp;
            ViewGroup localViewGroup = paramViewGroup;
            float f = androidx.core.b.a.g(paramAnonymousSeekBar.getProgress() / paramAnonymousSeekBar.getMax() * ((com.tencent.mm.plugin.finder.replay.viewmodel.c)locale.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).FmQ, 0.0F, ((com.tencent.mm.plugin.finder.replay.viewmodel.c)locale.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).FmQ - 1.0F);
            Log.i(e.a(locale), s.X("seek to ", Float.valueOf(f)));
            paramAnonymousSeekBar = (d)locale.getPlugin(d.class);
            if (paramAnonymousSeekBar != null)
            {
              double d = f;
              paramAnonymousSeekBar = paramAnonymousSeekBar.Fmd;
              if (paramAnonymousSeekBar != null)
              {
                Log.i("FinderLiveReplayerWidget", "seekVideo " + paramAnonymousSeekBar.hashCode() + " playerView:" + paramAnonymousSeekBar.Fni.hashCode() + " afterSeekPlay:true");
                paramAnonymousSeekBar.Fni.b(d, true);
                paramAnonymousSeekBar.Fni.bNU();
              }
            }
            e.c(locale).setImageDrawable(bb.e(localViewGroup.getContext().getDrawable(p.g.icons_filled_pause), -1));
          }
          AppMethodBeat.o(332943);
        }
      });
      this.Fmm.setOnClickListener((View.OnClickListener)this);
      paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.b((com.tencent.mm.plugin.finder.live.plugin.b)this);
      AppMethodBeat.o(332917);
      return;
      paramb = null;
      break;
    }
  }
  
  private static String RW(int paramInt)
  {
    AppMethodBeat.i(332921);
    if (paramInt >= 3600)
    {
      localObject = r.mZi;
      localObject = r.a.a(paramInt, ":", true, false, false, 24);
      AppMethodBeat.o(332921);
      return localObject;
    }
    Object localObject = r.mZi;
    localObject = r.a.a(paramInt, ":", false, false, false, 24);
    AppMethodBeat.o(332921);
    return localObject;
  }
  
  public final void RX(int paramInt)
  {
    AppMethodBeat.i(332950);
    if (((com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).FmQ > 0)
    {
      tO(0);
      this.uMM.setProgress((int)(paramInt / ((com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).FmQ * this.uMM.getMax()));
      String str = RW(paramInt);
      this.Fmn.setText((CharSequence)str);
      str = RW(((com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).FmQ);
      this.Fmo.setText((CharSequence)str);
    }
    AppMethodBeat.o(332950);
  }
  
  public final void eLU()
  {
    AppMethodBeat.i(332970);
    this.Fmm.setImageDrawable(bb.e(this.mJe.getContext().getDrawable(p.g.icons_filled_play), -1));
    tO(0);
    AppMethodBeat.o(332970);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(332979);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayerSeekbarPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.Cao;
      if (paramView != null) {
        break label90;
      }
    }
    label132:
    label207:
    label212:
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayerSeekbarPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(332979);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label90:
      if (paramView.intValue() == i)
      {
        localObject = (d)getPlugin(d.class);
        if (localObject != null)
        {
          paramView = eoH();
          if ((paramView instanceof FinderLiveReplayPluginLayout))
          {
            paramView = (FinderLiveReplayPluginLayout)paramView;
            if (paramView != null)
            {
              paramView = paramView.getUiClickListener();
              if (paramView != null) {
                if (((d)localObject).isPlaying()) {
                  break label207;
                }
              }
            }
          }
          for (boolean bool = true;; bool = false)
          {
            paramView.tv(bool);
            if (!((d)localObject).isPlaying()) {
              break label212;
            }
            this.Fmm.setImageDrawable(bb.e(this.mJe.getContext().getDrawable(p.g.icons_filled_play), -1));
            ((d)localObject).dSW();
            break;
            paramView = null;
            break label132;
          }
          this.Fmm.setImageDrawable(bb.e(this.mJe.getContext().getDrawable(p.g.icons_filled_pause), -1));
          d.a((d)localObject);
        }
      }
    }
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(332962);
    this.Fmm.setImageDrawable(bb.e(this.mJe.getContext().getDrawable(p.g.icons_filled_play), -1));
    tO(0);
    AppMethodBeat.o(332962);
  }
  
  public final void onVideoPlay()
  {
    AppMethodBeat.i(332957);
    this.Fmm.setImageDrawable(bb.e(this.mJe.getContext().getDrawable(p.g.icons_filled_pause), -1));
    AppMethodBeat.o(332957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.plugin.e
 * JD-Core Version:    0.7.0.1
 */
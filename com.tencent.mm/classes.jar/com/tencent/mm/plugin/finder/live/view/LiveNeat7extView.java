package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.utils.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/LiveNeat7extView;", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "invalidateVerifyPassTag", "getInvalidateVerifyPassTag", "setInvalidateVerifyPassTag", "(Ljava/lang/String;)V", "invalidateDrawable", "", "drawable", "Landroid/graphics/drawable/Drawable;", "scheduleDrawable", "who", "what", "Ljava/lang/Runnable;", "when", "", "unscheduleDrawable", "verifyDrawable", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveNeat7extView
  extends MMNeat7extView
{
  private final String TAG;
  private String akfH;
  
  public LiveNeat7extView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(371526);
    this.TAG = "LiveNeat7extView";
    this.akfH = "";
    AppMethodBeat.o(371526);
  }
  
  public final String getInvalidateVerifyPassTag()
  {
    return this.akfH;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(371530);
    s.u(paramDrawable, "drawable");
    Object localObject = a.DJT;
    String str = this.TAG;
    if ((paramDrawable instanceof j))
    {
      localObject = (j)paramDrawable;
      if (localObject != null) {
        break label64;
      }
    }
    label64:
    for (localObject = null;; localObject = ((j)localObject).getTag())
    {
      a.hQ(str, s.X("invalidateDrawable drawable:", localObject));
      super.invalidateDrawable(paramDrawable);
      AppMethodBeat.o(371530);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(371531);
    s.u(paramDrawable, "who");
    s.u(paramRunnable, "what");
    Object localObject = a.DJT;
    String str = this.TAG;
    if ((paramDrawable instanceof j))
    {
      localObject = (j)paramDrawable;
      if (localObject != null) {
        break label80;
      }
    }
    label80:
    for (localObject = null;; localObject = ((j)localObject).getTag())
    {
      a.hQ(str, s.X("scheduleDrawable drawable:", localObject));
      super.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      AppMethodBeat.o(371531);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void setInvalidateVerifyPassTag(String paramString)
  {
    AppMethodBeat.i(371528);
    s.u(paramString, "<set-?>");
    this.akfH = paramString;
    AppMethodBeat.o(371528);
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(371533);
    Object localObject = a.DJT;
    String str = this.TAG;
    if ((paramDrawable instanceof j))
    {
      localObject = (j)paramDrawable;
      if (localObject != null) {
        break label58;
      }
    }
    label58:
    for (localObject = null;; localObject = ((j)localObject).getTag())
    {
      a.hQ(str, s.X("unscheduleDrawable drawable:", localObject));
      super.unscheduleDrawable(paramDrawable);
      AppMethodBeat.o(371533);
      return;
      localObject = null;
      break;
    }
  }
  
  protected final boolean verifyDrawable(Drawable paramDrawable)
  {
    Object localObject2 = null;
    AppMethodBeat.i(371529);
    s.u(paramDrawable, "who");
    boolean bool = super.verifyDrawable(paramDrawable);
    Object localObject1 = a.DJT;
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("verifyDrawable superValud:").append(bool).append(" view tag:").append(this.akfH).append(",drawable tag:");
    if ((paramDrawable instanceof j))
    {
      localObject1 = (j)paramDrawable;
      if (localObject1 != null) {
        break label142;
      }
      localObject1 = null;
      label80:
      a.hQ(str, localObject1);
      if (!bool)
      {
        localObject1 = this.akfH;
        if (!(paramDrawable instanceof j)) {
          break label150;
        }
        paramDrawable = (j)paramDrawable;
        label115:
        if (paramDrawable != null) {
          break label155;
        }
      }
    }
    label142:
    label150:
    label155:
    for (paramDrawable = localObject2;; paramDrawable = paramDrawable.getTag())
    {
      if (!s.p(localObject1, paramDrawable)) {
        break label163;
      }
      AppMethodBeat.o(371529);
      return true;
      localObject1 = null;
      break;
      localObject1 = ((j)localObject1).getTag();
      break label80;
      paramDrawable = null;
      break label115;
    }
    label163:
    AppMethodBeat.o(371529);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.LiveNeat7extView
 * JD-Core Version:    0.7.0.1
 */
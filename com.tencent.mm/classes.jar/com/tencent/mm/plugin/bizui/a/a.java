package com.tencent.mm.plugin.bizui.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/bizui/util/BizViewUtils;", "", "()V", "TAG", "", "TITLE_SCENE_MP_CHAT", "", "TITLE_SCENE_MP_CHAT_COVER_TITLE", "TITLE_SCENE_MP_CHAT_ITEM", "TITLE_SCENE_PROFILE", "TITLE_SCENE_PROFILE_COVER_TITLE", "TITLE_SCENE_PROFILE_ITEM", "TITLE_SCENE_TIME_LINE", "TITLE_SCENE_TIME_LINE_COVER_TITLE", "TITLE_SCENE_TIME_LINE_ITEM", "widthMap", "Ljava/util/HashMap;", "getWidthMap", "()Ljava/util/HashMap;", "setWidthMap", "(Ljava/util/HashMap;)V", "appendIcon", "", "tv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "", "drawable", "Landroid/graphics/drawable/Drawable;", "padding", "getDefaultTitleWidth", "scene", "context", "Landroid/content/Context;", "getPaddingSpan", "Landroid/text/SpannableString;", "size", "getTitleWidth", "getViewTop", "root", "Landroid/view/View;", "target", "isCoverTitle", "", "setTitleEndWithPayIcon", "icon", "setTitleWidth", "width", "ui-biz_release"})
public final class a
{
  private static HashMap<Integer, Integer> nOZ;
  public static final a nPa;
  
  static
  {
    AppMethodBeat.i(123735);
    nPa = new a();
    nOZ = new HashMap();
    AppMethodBeat.o(123735);
  }
  
  private static SpannableString M(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(123734);
    Object localObject = paramContext.getResources().getDrawable(2131233299);
    ((Drawable)localObject).setBounds(0, 0, com.tencent.mm.cc.a.fromDPToPix(paramContext, 8), paramInt);
    paramContext = new com.tencent.mm.ui.widget.a((Drawable)localObject);
    localObject = new SpannableString((CharSequence)"@");
    ((SpannableString)localObject).setSpan(paramContext, 0, 1, 33);
    AppMethodBeat.o(123734);
    return localObject;
  }
  
  public static void a(Context paramContext, MMNeat7extView paramMMNeat7extView, int paramInt1, CharSequence paramCharSequence, final int paramInt2)
  {
    AppMethodBeat.i(123732);
    p.h(paramContext, "context");
    p.h(paramMMNeat7extView, "tv");
    p.h(paramCharSequence, "text");
    paramMMNeat7extView.ar(paramCharSequence);
    int j;
    int i;
    Object localObject;
    if (paramMMNeat7extView.getWidth() > 0)
    {
      j = paramMMNeat7extView.getWidth();
      i = j;
      if (j <= 0)
      {
        localObject = paramMMNeat7extView.getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new a(paramMMNeat7extView, paramInt2));
        }
        if ((paramInt2 != 0) && (paramInt2 != 11)) {
          break label301;
        }
        i = com.tencent.mm.cc.a.ip(paramContext) - com.tencent.mm.cc.a.fromDPToPix(paramContext, 48);
      }
    }
    for (;;)
    {
      localObject = paramContext.getResources().getDrawable(paramInt1);
      paramInt1 = (int)paramMMNeat7extView.getTextSize();
      p.g(localObject, "drawable");
      paramInt2 = ((Drawable)localObject).getIntrinsicWidth() * paramInt1 / ((Drawable)localObject).getIntrinsicHeight();
      ((Drawable)localObject).setBounds(0, 0, paramInt2, paramInt1);
      float f1 = paramInt2;
      float f2 = com.tencent.mm.cc.a.fromDPToPix(paramContext, 9);
      paramMMNeat7extView.a(TextUtils.TruncateAt.END, f1 + f2);
      paramContext = paramMMNeat7extView.kK(i, 2147483647);
      if (paramContext == null) {
        break label498;
      }
      paramInt1 = paramContext.getEllipsisCount(paramMMNeat7extView.getMaxLines() - 1);
      if (paramInt1 > 0) {
        break label444;
      }
      a(paramMMNeat7extView, paramCharSequence, (Drawable)localObject);
      AppMethodBeat.o(123732);
      return;
      if (((Map)nOZ).containsKey(Integer.valueOf(paramInt2)))
      {
        localObject = nOZ.get(Integer.valueOf(paramInt2));
        if (localObject == null) {
          p.gfZ();
        }
        j = ((Number)localObject).intValue();
        break;
      }
      ((Map)nOZ).put(Integer.valueOf(paramInt2), Integer.valueOf(0));
      j = 0;
      break;
      label301:
      if (paramInt2 == 1) {
        i = com.tencent.mm.cc.a.ip(paramContext) - com.tencent.mm.cc.a.fromDPToPix(paramContext, 136);
      } else if ((paramInt2 == 2) || (paramInt2 == 21)) {
        i = com.tencent.mm.cc.a.ip(paramContext) - com.tencent.mm.cc.a.fromDPToPix(paramContext, 64);
      } else if (paramInt2 == 3) {
        i = com.tencent.mm.cc.a.ip(paramContext) - com.tencent.mm.cc.a.fromDPToPix(paramContext, 136);
      } else if ((paramInt2 == 4) || (paramInt2 == 41)) {
        i = com.tencent.mm.cc.a.ip(paramContext) - com.tencent.mm.cc.a.fromDPToPix(paramContext, 64);
      } else if (paramInt2 == 5) {
        i = com.tencent.mm.cc.a.ip(paramContext) - com.tencent.mm.cc.a.fromDPToPix(paramContext, 144);
      } else {
        i = com.tencent.mm.cc.a.ip(paramContext) - com.tencent.mm.cc.a.fromDPToPix(paramContext, 64);
      }
    }
    label444:
    paramContext = paramCharSequence.subSequence(0, paramCharSequence.length() - paramInt1).toString();
    a(paramMMNeat7extView, (CharSequence)(paramContext + '…'), (Drawable)localObject);
    AppMethodBeat.o(123732);
    return;
    label498:
    a(paramMMNeat7extView, paramCharSequence, (Drawable)localObject);
    AppMethodBeat.o(123732);
  }
  
  private static void a(MMNeat7extView paramMMNeat7extView, CharSequence paramCharSequence, Drawable paramDrawable)
  {
    AppMethodBeat.i(123733);
    p.h(paramMMNeat7extView, "tv");
    p.h(paramCharSequence, "text");
    p.h(paramDrawable, "drawable");
    paramMMNeat7extView.a(TextUtils.TruncateAt.END, 0.0F);
    Object localObject = new com.tencent.mm.ui.widget.a(paramDrawable);
    paramDrawable = new SpannableString((CharSequence)"@");
    paramDrawable.setSpan(localObject, 0, 1, 33);
    localObject = paramMMNeat7extView.getContext();
    p.g(localObject, "tv.context");
    paramMMNeat7extView.ar(TextUtils.concat(new CharSequence[] { paramCharSequence, (CharSequence)M((Context)localObject, (int)paramMMNeat7extView.getTextSize()), (CharSequence)paramDrawable }));
    AppMethodBeat.o(123733);
  }
  
  public static int i(View paramView1, View paramView2)
  {
    AppMethodBeat.i(123731);
    if ((paramView1 == null) || (paramView2 == null) || (paramView1 == paramView2))
    {
      AppMethodBeat.o(123731);
      return 0;
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (paramView2 == paramView1) {
        break;
      }
      i += paramView2.getTop();
      ad.v("MicroMsg.BizViewUtils", "alvinluo getViewTop top: %d", new Object[] { Integer.valueOf(i) });
      j = i;
      if (!(paramView2.getParent() instanceof View)) {
        break;
      }
      paramView2 = paramView2.getParent();
      if (paramView2 == null)
      {
        paramView1 = new v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(123731);
        throw paramView1;
      }
      paramView2 = (View)paramView2;
    }
    AppMethodBeat.o(123731);
    return j;
  }
  
  public static boolean yU(int paramInt)
  {
    return (paramInt == 11) || (paramInt == 21) || (paramInt == 41);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/bizui/util/BizViewUtils$setTitleEndWithPayIcon$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "ui-biz_release"})
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a(MMNeat7extView paramMMNeat7extView, int paramInt) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(123730);
      ViewTreeObserver localViewTreeObserver = this.nPb.getViewTreeObserver();
      if (localViewTreeObserver != null) {
        localViewTreeObserver.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      }
      this.nPb.post((Runnable)new a(this));
      AppMethodBeat.o(123730);
      return true;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(123729);
        a locala = a.nPa;
        a.eM(this.nPc.hST, this.nPc.nPb.getWidth());
        AppMethodBeat.o(123729);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bizui.a.a
 * JD-Core Version:    0.7.0.1
 */
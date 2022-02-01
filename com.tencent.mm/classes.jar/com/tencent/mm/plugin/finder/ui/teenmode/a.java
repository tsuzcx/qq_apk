package com.tencent.mm.plugin.finder.ui.teenmode;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.message.a.c;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.findersdk.a.f;
import com.tencent.mm.plugin.teenmode.a.a.b;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/teenmode/FinderAuthorizationFiller;", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller;", "()V", "fillCellByGuard", "", "holder", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller$Holder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "fillCellByWard", "isEnable", "", "getBizTypeDesc", "", "context", "Landroid/content/Context;", "handleCellClick", "obj", "handleTempByGuard", "state", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller$State;", "handleTempByWard", "onFill", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.teenmode.a.a
{
  private static final void a(a parama, com.tencent.mm.plugin.teenmode.a.a.a parama1, bvl parambvl, View paramView)
  {
    AppMethodBeat.i(347267);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(parama1);
    localb.cH(parambvl);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/teenmode/FinderAuthorizationFiller", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    s.u(parama1, "$holder");
    s.u(parambvl, "$obj");
    a(parama1, parambvl);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/teenmode/FinderAuthorizationFiller", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347267);
  }
  
  private static void a(com.tencent.mm.plugin.teenmode.a.a.a parama, bvl parambvl)
  {
    AppMethodBeat.i(347254);
    parama = parama.mll.getContext();
    Intent localIntent = new Intent();
    localIntent.putExtra("feed_object_id", d.FK(parambvl.objectId));
    localIntent.putExtra("feed_object_nonceId", parambvl.objectNonceId);
    localIntent.putExtra("key_need_related_list", false);
    localIntent.putExtra("key_comment_scene", 25);
    if (parambvl.GfT == 11111) {
      localIntent.putExtra("business_type", 1);
    }
    parambvl = com.tencent.mm.plugin.finder.utils.a.GfO;
    s.s(parama, "context");
    com.tencent.mm.plugin.finder.utils.a.Y(parama, localIntent);
    AppMethodBeat.o(347254);
  }
  
  private final void a(com.tencent.mm.plugin.teenmode.a.a.a parama, bvl parambvl, boolean paramBoolean)
  {
    AppMethodBeat.i(347242);
    Object localObject;
    int i;
    if (parambvl != null)
    {
      localObject = parambvl.mediaList;
      if (localObject != null)
      {
        if (((Collection)localObject).isEmpty()) {
          break label131;
        }
        i = 1;
        if (i == 0) {
          break label137;
        }
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = ((LinkedList)localObject).getFirst();
        s.s(localObject, "list.first");
        localObject = (bvj)localObject;
        r.bKe().loadImage(((bvj)localObject).thumbUrl, parama.SYq);
      }
      parama.SYs.setText((CharSequence)parambvl.desc);
      parama.SYr.setVisibility(0);
      if (paramBoolean) {
        parama.SYp.setOnClickListener(new a..ExternalSyntheticLambda0(this, parama, parambvl));
      }
      AppMethodBeat.o(347242);
      return;
      label131:
      i = 0;
      break;
      label137:
      localObject = null;
    }
  }
  
  private static final void b(a parama, com.tencent.mm.plugin.teenmode.a.a.a parama1, bvl parambvl, View paramView)
  {
    AppMethodBeat.i(347281);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(parama1);
    localb.cH(parambvl);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/teenmode/FinderAuthorizationFiller", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    s.u(parama1, "$holder");
    s.u(parambvl, "$obj");
    a(parama1, parambvl);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/teenmode/FinderAuthorizationFiller", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347281);
  }
  
  public final void a(Context paramContext, a.b paramb, com.tencent.mm.plugin.teenmode.a.a.a parama)
  {
    AppMethodBeat.i(347344);
    s.u(paramContext, "context");
    s.u(paramb, "state");
    if (parama == null)
    {
      AppMethodBeat.o(347344);
      return;
    }
    Object localObject = (c)parama.SYk.aK(c.class);
    boolean bool = z.bAM().equals(parama.SYo);
    label395:
    int i;
    if (localObject != null)
    {
      paramContext = XmlParser.parseXml(((c)localObject).nVJ, "content", null);
      if (paramContext == null)
      {
        AppMethodBeat.o(347344);
        return;
      }
      paramContext = (String)paramContext.get(".content");
      if (paramContext == null)
      {
        AppMethodBeat.o(347344);
        return;
      }
      paramContext = k.b.Hf(paramContext);
      if (paramContext == null)
      {
        AppMethodBeat.o(347344);
        return;
      }
      paramContext = (f)paramContext.aK(f.class);
      if (paramContext == null)
      {
        paramContext = null;
        Log.i("FinderAuthorizationFiller", "onFill, state:" + paramb + ", isWard:" + bool + ", piece.referMsg:" + ((c)localObject).nVJ);
        if (!bool) {
          break label395;
        }
        localObject = parama.mll.getContext();
        switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(347344);
        return;
        paramContext = paramContext.oUc;
        break;
        parama.pmf.setText((CharSequence)((Context)localObject).getResources().getString(e.h.finder_teen_mode_guardian_temp_req_ward_subtitle));
        a(parama, paramContext, false);
        AppMethodBeat.o(347344);
        return;
        parama.pmf.setText((CharSequence)((Context)localObject).getResources().getString(e.h.finder_teen_mode_guardian_req_overtime_subtitle));
        a(parama, paramContext, false);
        AppMethodBeat.o(347344);
        return;
        parama.pmf.setText((CharSequence)((Context)localObject).getResources().getString(e.h.finder_teen_mode_guardian_temp_req_agree_ward_subtitle));
        a(parama, paramContext, true);
        AppMethodBeat.o(347344);
        return;
        parama.pmf.setText((CharSequence)((Context)localObject).getResources().getString(e.h.finder_teen_mode_guardian_temp_req_agree_expired_ward_subtitle));
        a(parama, paramContext, false);
      }
      localObject = parama.mll.getContext();
      switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      default: 
        if (paramContext != null)
        {
          paramb = paramContext.mediaList;
          if (paramb != null)
          {
            if (((Collection)paramb).isEmpty()) {
              break label674;
            }
            i = 1;
            label472:
            if (i == 0) {
              break label680;
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (paramb != null)
      {
        paramb = paramb.getFirst();
        s.s(paramb, "list.first");
        paramb = (bvj)paramb;
        r.bKe().loadImage(paramb.thumbUrl, parama.SYq);
      }
      parama.SYs.setText((CharSequence)paramContext.desc);
      parama.SYp.setOnClickListener(new a..ExternalSyntheticLambda1(this, parama, paramContext));
      parama.SYr.setVisibility(0);
      AppMethodBeat.o(347344);
      return;
      parama.mll.setText((CharSequence)((Context)localObject).getResources().getString(e.h.finder_teen_mode_guardian_temp_req_title));
      parama.pmf.setText((CharSequence)((Context)localObject).getResources().getString(e.h.finder_teen_mode_guardian_temp_req_subtitle));
      break;
      parama.pmf.setText((CharSequence)((Context)localObject).getResources().getString(e.h.finder_teen_mode_guardian_req_overtime_subtitle));
      break;
      parama.pmf.setText((CharSequence)((Context)localObject).getResources().getString(e.h.finder_teen_mode_guardian_temp_req_agree_subtitle));
      break;
      parama.pmf.setText((CharSequence)((Context)localObject).getResources().getString(e.h.finder_teen_mode_guardian_temp_req_agree_expired_subtitle));
      break;
      label674:
      i = 0;
      break label472;
      label680:
      paramb = null;
    }
  }
  
  public final String gV(Context paramContext)
  {
    AppMethodBeat.i(347315);
    s.u(paramContext, "context");
    paramContext = paramContext.getString(e.h.finder_title);
    s.s(paramContext, "context.getString(R.string.finder_title)");
    AppMethodBeat.o(347315);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.teenmode.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.card.ui.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.c;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.plugin.card.c.q;
import com.tencent.mm.plugin.card.mgr.i.b;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

public abstract class h
  implements ab
{
  protected g wJp;
  protected MMActivity wry;
  
  public h(g paramg, MMActivity paramMMActivity)
  {
    this.wJp = paramg;
    this.wry = paramMMActivity;
  }
  
  public void c(ViewGroup paramViewGroup, final com.tencent.mm.plugin.card.base.b paramb)
  {
    Object localObject1;
    Object localObject2;
    if (doF())
    {
      localObject1 = (TextView)paramViewGroup.findViewById(a.d.wjG);
      localObject2 = this.wJp.code;
      if ((!paramb.djD()) && ((Util.isNullOrNil((String)localObject2)) || (((String)localObject2).length() > 40))) {
        break label304;
      }
      ((TextView)localObject1).setText(n.alC((String)localObject2));
      if (paramb.djy())
      {
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113672);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
            if (paramAnonymousView.getId() == a.d.wjG)
            {
              q.TF(paramb.djL().code);
              k.cZ(h.this.wry, p.getString(a.g.app_copy_ok));
            }
            a.a(false, this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(113672);
            return false;
          }
        });
        this.wJp.d(c.wKq);
      }
    }
    else if (doG())
    {
      localObject1 = (LinearLayout)paramViewGroup.findViewById(a.d.wju);
      if ((paramb == null) || (paramb.djK() == null) || (paramb.djK().Zen == null) || (Util.isNullOrNil(paramb.djK().Zen.title))) {
        break label326;
      }
      paramViewGroup.findViewById(a.d.wjs).setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(0);
      localObject2 = paramb.djK().Zen;
      TextView localTextView = (TextView)paramViewGroup.findViewById(a.d.wjw);
      localTextView.setText(((aek)localObject2).title);
      String str = paramb.djK().nRQ;
      if (!Util.isNullOrNil(str)) {
        localTextView.setTextColor(l.alv(str));
      }
      paramViewGroup = (TextView)paramViewGroup.findViewById(a.d.wjv);
      localObject2 = ((aek)localObject2).wsA;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label313;
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setText((CharSequence)localObject2);
        paramViewGroup.setVisibility(0);
      }
    }
    for (;;)
    {
      ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113673);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if (paramb.djC())
          {
            paramAnonymousView = new i.b();
            com.tencent.mm.plugin.card.c.b.a(h.this.wJp.wry, paramAnonymousView.wso, paramAnonymousView.wsp, false, paramb);
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113673);
            return;
            paramAnonymousView = paramb.djK().Zen;
            if ((paramAnonymousView != null) && (!Util.isNullOrNil(paramAnonymousView.Zdx)) && (!Util.isNullOrNil(paramAnonymousView.Zdw)))
            {
              int i;
              if (h.this.wry.getIntent() != null)
              {
                i = h.this.wry.getIntent().getIntExtra("key_from_scene", 3);
                label168:
                if (h.this.wry.getIntent() == null) {
                  break label279;
                }
              }
              label279:
              for (int j = h.this.wry.getIntent().getIntExtra("key_from_appbrand_type", 0);; j = 0)
              {
                com.tencent.mm.plugin.card.c.b.a(paramb.djO(), paramAnonymousView, i, j);
                com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(20), paramb.djO(), paramb.djP(), "", paramAnonymousView.title });
                break;
                i = 3;
                break label168;
              }
            }
            if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
            {
              localObject = l.ad(paramAnonymousView.url, paramAnonymousView.ZeU);
              com.tencent.mm.plugin.card.c.b.a(h.this.wJp.wry, (String)localObject, 1);
              com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(9), paramb.djO(), paramb.djP(), "", paramAnonymousView.title });
              if (l.a(paramAnonymousView, paramb.djO()))
              {
                l.alA(paramb.djO());
                com.tencent.mm.plugin.card.c.b.a(h.this.wJp.wry, paramb.djK().mee);
              }
            }
          }
        }
      });
      return;
      ((TextView)localObject1).setVisibility(8);
      break;
      label304:
      ((TextView)localObject1).setVisibility(8);
      break;
      label313:
      if (paramViewGroup != null) {
        paramViewGroup.setVisibility(8);
      }
    }
    label326:
    ((LinearLayout)localObject1).setVisibility(8);
  }
  
  public abstract boolean doF();
  
  public abstract boolean doG();
  
  public boolean g(com.tencent.mm.plugin.card.base.b paramb)
  {
    return true;
  }
  
  public void s(ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.h
 * JD-Core Version:    0.7.0.1
 */
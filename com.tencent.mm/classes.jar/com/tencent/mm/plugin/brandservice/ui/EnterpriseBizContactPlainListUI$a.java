package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.p;

final class EnterpriseBizContactPlainListUI$a
  extends p<me>
  implements n.b
{
  b gxo;
  private b.b gxp;
  
  public EnterpriseBizContactPlainListUI$a(EnterpriseBizContactPlainListUI paramEnterpriseBizContactPlainListUI, Context paramContext)
  {
    super(paramContext, new me());
    AppMethodBeat.i(13990);
    this.gxp = null;
    this.gxo = new b(new EnterpriseBizContactPlainListUI.a.1(this));
    Ku();
    AppMethodBeat.o(13990);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(13994);
    if (!g.RG())
    {
      ab.e("MicroMsg.EnterpriseBizListAdapter", "accHasReady");
      AppMethodBeat.o(13994);
      return;
    }
    bKb();
    Object localObject2 = null;
    Object localObject1;
    switch (EnterpriseBizContactPlainListUI.b(this.jUA))
    {
    default: 
      z.afi();
      localObject1 = e.G(EnterpriseBizContactPlainListUI.c(this.jUA), true);
    }
    for (;;)
    {
      setCursor((Cursor)localObject1);
      AppMethodBeat.o(13994);
      return;
      z.afi();
      localObject1 = e.V(EnterpriseBizContactPlainListUI.c(this.jUA), 25);
      continue;
      z.afi();
      localObject1 = e.rM(EnterpriseBizContactPlainListUI.c(this.jUA));
      continue;
      z.afi();
      localObject1 = e.V(EnterpriseBizContactPlainListUI.c(this.jUA), 128);
      continue;
      d locald = f.rS(EnterpriseBizContactPlainListUI.c(this.jUA));
      localObject1 = localObject2;
      if (locald != null)
      {
        localObject1 = localObject2;
        if (locald.field_enterpriseFather != null) {
          localObject1 = z.afi().rL(locald.field_enterpriseFather);
        }
      }
    }
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(156910);
    Ku();
    AppMethodBeat.o(156910);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(13991);
    ab.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange");
    al.d(new EnterpriseBizContactPlainListUI.a.2(this));
    AppMethodBeat.o(13991);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(13992);
    if (this.gxp == null) {
      this.gxp = new EnterpriseBizContactPlainListUI.a.3(this);
    }
    if (this.gxo != null) {
      this.gxo.a(paramInt, this.gxp);
    }
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = View.inflate(this.context, 2130969427, null);
      paramViewGroup.gxs = ((ImageView)paramView.findViewById(2131823731));
      paramViewGroup.gvI = ((TextView)paramView.findViewById(2131823732));
      paramView.setTag(paramViewGroup);
    }
    me localme;
    for (;;)
    {
      localme = (me)getItem(paramInt);
      if (localme != null) {
        break;
      }
      paramViewGroup.clear();
      AppMethodBeat.o(13992);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.clear();
    paramInt = paramView.getPaddingBottom();
    int i = paramView.getPaddingTop();
    int j = paramView.getPaddingRight();
    int k = paramView.getPaddingLeft();
    paramView.setBackgroundDrawable(a.k(this.context, 2130838445));
    paramView.setPadding(k, i, j, paramInt);
    String str = bo.nullAsNil(localme.contact.Oe());
    paramViewGroup.gvI.setText(j.b(this.context, str, paramViewGroup.gvI.getTextSize()));
    paramViewGroup.gvI.setVisibility(0);
    paramViewGroup.gxs.setVisibility(0);
    if (!bo.isNullOrNil(localme.contact.field_username)) {
      a.b.c(paramViewGroup.gxs, localme.contact.field_username);
    }
    for (;;)
    {
      AppMethodBeat.o(13992);
      return paramView;
      paramViewGroup.gxs.setImageDrawable(null);
    }
  }
  
  final class a
  {
    TextView gvI;
    ImageView gxs;
    
    a() {}
    
    public final void clear()
    {
      AppMethodBeat.i(13989);
      if (this.gxs != null)
      {
        this.gxs.setImageDrawable(null);
        this.gxs.setVisibility(8);
      }
      if (this.gvI != null)
      {
        this.gvI.setText("");
        this.gvI.setVisibility(8);
      }
      AppMethodBeat.o(13989);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.a
 * JD-Core Version:    0.7.0.1
 */
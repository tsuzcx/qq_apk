package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.plugin.account.friend.model.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;

@Deprecated
final class g
  extends x<com.tencent.mm.plugin.account.friend.model.d>
{
  private int[] duY;
  private String pQS;
  g.a qbP;
  
  public g(Context paramContext, x.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.model.d());
    AppMethodBeat.i(304989);
    super.a(parama);
    AppMethodBeat.o(304989);
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(304995);
    this.pQS = Util.escapeSqlValue(paramString.trim());
    fSd();
    aNy();
    AppMethodBeat.o(304995);
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(304994);
    w(b.getFacebookFrdStg().SY(this.pQS));
    this.duY = new int[getCount()];
    if ((this.qbP != null) && (this.pQS != null)) {
      this.qbP.yo(Fv().getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(304994);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(304993);
    aNy();
    AppMethodBeat.o(304993);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(304999);
    Object localObject = (com.tencent.mm.plugin.account.friend.model.d)getItem(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new b();
      paramView = View.inflate(this.context, r.g.facebook_friend_item, null);
      paramViewGroup.lKK = ((ImageView)paramView.findViewById(r.f.contactitem_avatar_iv));
      paramViewGroup.pQZ = ((TextView)paramView.findViewById(r.f.qq_friend_name));
      paramViewGroup.pSI = ((TextView)paramView.findViewById(r.f.qq_friend_add_state));
      paramViewGroup.qbQ = ((TextView)paramView.findViewById(r.f.qq_friend_add_tv));
      paramViewGroup.qbR = ((TextView)paramView.findViewById(r.f.qq_friend_invite_tv));
      paramViewGroup.qbS = ((ImageView)paramView.findViewById(r.f.qq_friend_submenu));
      paramView.setTag(paramViewGroup);
      paramViewGroup.pQZ.setText(p.b(this.context, ((com.tencent.mm.plugin.account.friend.model.d)localObject).bWR(), paramViewGroup.pQZ.getTextSize()));
      paramViewGroup.qbR.setVisibility(8);
      paramViewGroup.qbS.setVisibility(0);
      switch (this.duY[paramInt])
      {
      case 1: 
      default: 
        label204:
        localObject = com.tencent.mm.modelavatar.d.Lv(((com.tencent.mm.plugin.account.friend.model.d)localObject).kaa);
        if (localObject == null) {
          paramViewGroup.lKK.setImageDrawable(a.m(this.context, r.i.default_avatar));
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(304999);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      paramViewGroup.qbQ.setVisibility(8);
      paramViewGroup.pSI.setVisibility(0);
      paramViewGroup.pSI.setText(r.j.friend_waiting);
      paramViewGroup.pSI.setTextColor(this.context.getResources().getColor(r.c.add_state_color_waiting));
      break label204;
      if ((((com.tencent.mm.plugin.account.friend.model.d)localObject).status != 102) && (!((n)h.ax(n.class)).bzA().bxr(((com.tencent.mm.plugin.account.friend.model.d)localObject).getUsername())))
      {
        paramViewGroup.pSI.setVisibility(8);
        paramViewGroup.qbQ.setVisibility(0);
        break label204;
      }
      if (((com.tencent.mm.plugin.account.friend.model.d)localObject).status == 102)
      {
        paramViewGroup.pSI.setVisibility(8);
        paramViewGroup.qbQ.setVisibility(8);
        paramViewGroup.qbS.setVisibility(8);
        break label204;
      }
      paramViewGroup.pSI.setVisibility(0);
      paramViewGroup.pSI.setText(r.j.friend_added);
      paramViewGroup.pSI.setTextColor(this.context.getResources().getColor(r.c.add_state_color_added));
      paramViewGroup.qbQ.setVisibility(8);
      break label204;
      paramViewGroup.lKK.setImageBitmap((Bitmap)localObject);
    }
  }
  
  static final class b
  {
    ImageView lKK;
    TextView pQZ;
    TextView pSI;
    TextView qbQ;
    TextView qbR;
    ImageView qbS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.g
 * JD-Core Version:    0.7.0.1
 */
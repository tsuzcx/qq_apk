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
import com.tencent.mm.am.d;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.v.a;

@Deprecated
final class e
  extends v<g>
{
  private int[] bBW;
  private String mUk;
  a ncC;
  
  public e(Context paramContext, v.a parama)
  {
    super(paramContext, new g());
    AppMethodBeat.i(127952);
    super.a(parama);
    AppMethodBeat.o(127952);
  }
  
  public final void aas(String paramString)
  {
    AppMethodBeat.i(127955);
    this.mUk = Util.escapeSqlValue(paramString.trim());
    eKd();
    atr();
    AppMethodBeat.o(127955);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(127954);
    v(b.getFacebookFrdStg().aaE(this.mUk));
    this.bBW = new int[getCount()];
    if ((this.ncC != null) && (this.mUk != null)) {
      this.ncC.yi(hK().getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(127954);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(127953);
    atr();
    AppMethodBeat.o(127953);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(127956);
    Object localObject = (g)getItem(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new b();
      paramView = View.inflate(this.context, r.g.facebook_friend_item, null);
      paramViewGroup.jiu = ((ImageView)paramView.findViewById(r.f.contactitem_avatar_iv));
      paramViewGroup.mUr = ((TextView)paramView.findViewById(r.f.qq_friend_name));
      paramViewGroup.mWc = ((TextView)paramView.findViewById(r.f.qq_friend_add_state));
      paramViewGroup.ncD = ((TextView)paramView.findViewById(r.f.qq_friend_add_tv));
      paramViewGroup.ncE = ((TextView)paramView.findViewById(r.f.qq_friend_invite_tv));
      paramViewGroup.ncF = ((ImageView)paramView.findViewById(r.f.qq_friend_submenu));
      paramView.setTag(paramViewGroup);
      paramViewGroup.mUr.setText(l.b(this.context, ((g)localObject).byc(), paramViewGroup.mUr.getTextSize()));
      paramViewGroup.ncE.setVisibility(8);
      paramViewGroup.ncF.setVisibility(0);
      switch (this.bBW[paramInt])
      {
      case 1: 
      default: 
        label204:
        localObject = d.Tt(((g)localObject).hDe);
        if (localObject == null) {
          paramViewGroup.jiu.setImageDrawable(a.m(this.context, r.i.default_avatar));
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(127956);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      paramViewGroup.ncD.setVisibility(8);
      paramViewGroup.mWc.setVisibility(0);
      paramViewGroup.mWc.setText(r.j.friend_waiting);
      paramViewGroup.mWc.setTextColor(this.context.getResources().getColor(r.c.add_state_color_waiting));
      break label204;
      if ((((g)localObject).status != 102) && (!((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwd(((g)localObject).getUsername())))
      {
        paramViewGroup.mWc.setVisibility(8);
        paramViewGroup.ncD.setVisibility(0);
        break label204;
      }
      if (((g)localObject).status == 102)
      {
        paramViewGroup.mWc.setVisibility(8);
        paramViewGroup.ncD.setVisibility(8);
        paramViewGroup.ncF.setVisibility(8);
        break label204;
      }
      paramViewGroup.mWc.setVisibility(0);
      paramViewGroup.mWc.setText(r.j.friend_added);
      paramViewGroup.mWc.setTextColor(this.context.getResources().getColor(r.c.add_state_color_added));
      paramViewGroup.ncD.setVisibility(8);
      break label204;
      paramViewGroup.jiu.setImageBitmap((Bitmap)localObject);
    }
  }
  
  public static abstract interface a
  {
    public abstract void yi(int paramInt);
  }
  
  static final class b
  {
    ImageView jiu;
    TextView mUr;
    TextView mWc;
    TextView ncD;
    TextView ncE;
    ImageView ncF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.e
 * JD-Core Version:    0.7.0.1
 */
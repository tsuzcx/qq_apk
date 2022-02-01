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
import com.tencent.mm.aj.c;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.a;

@Deprecated
final class e
  extends s<com.tencent.mm.plugin.account.friend.a.g>
{
  private String kcL;
  a kkM;
  private int[] pt;
  
  public e(Context paramContext, s.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.g());
    AppMethodBeat.i(127952);
    super.a(parama);
    AppMethodBeat.o(127952);
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(127955);
    this.kcL = Util.escapeSqlValue(paramString.trim());
    ebf();
    anp();
    AppMethodBeat.o(127955);
  }
  
  public final void anp()
  {
    AppMethodBeat.i(127954);
    setCursor(com.tencent.mm.plugin.account.a.getFacebookFrdStg().SY(this.kcL));
    this.pt = new int[getCount()];
    if ((this.kkM != null) && (this.kcL != null)) {
      this.kkM.ve(getCursor().getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(127954);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(127953);
    anp();
    AppMethodBeat.o(127953);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(127956);
    Object localObject = (com.tencent.mm.plugin.account.friend.a.g)getItem(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new b();
      paramView = View.inflate(this.context, 2131494097, null);
      paramViewGroup.gyr = ((ImageView)paramView.findViewById(2131299160));
      paramViewGroup.kcS = ((TextView)paramView.findViewById(2131306336));
      paramViewGroup.keD = ((TextView)paramView.findViewById(2131306331));
      paramViewGroup.kkN = ((TextView)paramView.findViewById(2131306332));
      paramViewGroup.kkO = ((TextView)paramView.findViewById(2131306334));
      paramViewGroup.kkP = ((ImageView)paramView.findViewById(2131306339));
      paramView.setTag(paramViewGroup);
      paramViewGroup.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, ((com.tencent.mm.plugin.account.friend.a.g)localObject).bnT(), paramViewGroup.kcS.getTextSize()));
      paramViewGroup.kkO.setVisibility(8);
      paramViewGroup.kkP.setVisibility(0);
      switch (this.pt[paramInt])
      {
      case 1: 
      default: 
        label196:
        localObject = c.LY(((com.tencent.mm.plugin.account.friend.a.g)localObject).fuC);
        if (localObject == null) {
          paramViewGroup.gyr.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690042));
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
      paramViewGroup.kkN.setVisibility(8);
      paramViewGroup.keD.setVisibility(0);
      paramViewGroup.keD.setText(2131760987);
      paramViewGroup.keD.setTextColor(this.context.getResources().getColor(2131099911));
      break label196;
      if ((((com.tencent.mm.plugin.account.friend.a.g)localObject).status != 102) && (!((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjG(((com.tencent.mm.plugin.account.friend.a.g)localObject).getUsername())))
      {
        paramViewGroup.keD.setVisibility(8);
        paramViewGroup.kkN.setVisibility(0);
        break label196;
      }
      if (((com.tencent.mm.plugin.account.friend.a.g)localObject).status == 102)
      {
        paramViewGroup.keD.setVisibility(8);
        paramViewGroup.kkN.setVisibility(8);
        paramViewGroup.kkP.setVisibility(8);
        break label196;
      }
      paramViewGroup.keD.setVisibility(0);
      paramViewGroup.keD.setText(2131760983);
      paramViewGroup.keD.setTextColor(this.context.getResources().getColor(2131099910));
      paramViewGroup.kkN.setVisibility(8);
      break label196;
      paramViewGroup.gyr.setImageBitmap((Bitmap)localObject);
    }
  }
  
  public static abstract interface a
  {
    public abstract void ve(int paramInt);
  }
  
  static final class b
  {
    ImageView gyr;
    TextView kcS;
    TextView keD;
    TextView kkN;
    TextView kkO;
    ImageView kkP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.e
 * JD-Core Version:    0.7.0.1
 */
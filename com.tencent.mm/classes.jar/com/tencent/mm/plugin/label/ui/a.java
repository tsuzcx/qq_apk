package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ao.o;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.contact.f;
import com.tencent.mm.ui.v;
import java.util.List;
import java.util.Map;

public final class a
  extends v<f>
{
  public static final ColorStateList Eeh;
  public static final ColorStateList Eei;
  List<String> Eej;
  
  static
  {
    AppMethodBeat.i(26260);
    Eeh = com.tencent.mm.ci.a.l(MMApplicationContext.getContext(), R.e.mm_list_textcolor_one);
    Eei = com.tencent.mm.ci.a.l(MMApplicationContext.getContext(), R.e.hint_text_color);
    AppMethodBeat.o(26260);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, new f());
    AppMethodBeat.i(26250);
    AppMethodBeat.o(26250);
  }
  
  private static f a(f paramf, Cursor paramCursor)
  {
    AppMethodBeat.i(26256);
    f localf = paramf;
    if (paramf == null) {
      localf = new f();
    }
    bh.beI();
    paramf = com.tencent.mm.model.c.bbL().bwc(as.s(paramCursor));
    if (paramf == null)
    {
      localf.contact.convertFrom(paramCursor);
      bh.beI();
      com.tencent.mm.model.c.bbL().as(localf.contact);
    }
    for (;;)
    {
      AppMethodBeat.o(26256);
      return localf;
      localf.contact = paramf;
    }
  }
  
  public final f VD(int paramInt)
  {
    AppMethodBeat.i(26252);
    if (TR(paramInt))
    {
      localf = (f)ezC();
      AppMethodBeat.o(26252);
      return localf;
    }
    if (this.VZb != null)
    {
      localf = (f)this.VZb.get(Integer.valueOf(paramInt));
      if (localf != null)
      {
        AppMethodBeat.o(26252);
        return localf;
      }
    }
    if ((paramInt < 0) || (!hK().moveToPosition(paramInt)))
    {
      AppMethodBeat.o(26252);
      return null;
    }
    f localf = a(null, hK());
    if (this.VZb == null) {
      Fx(true);
    }
    if (this.VZb != null) {
      this.VZb.put(Integer.valueOf(paramInt), localf);
    }
    AppMethodBeat.o(26252);
    return localf;
  }
  
  /* Error */
  public final void atr()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 26254
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 152	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   11: invokestatic 155	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   14: if_acmpne +59 -> 73
    //   17: iconst_1
    //   18: istore_1
    //   19: aload_0
    //   20: getfield 157	com/tencent/mm/plugin/label/ui/a:Eej	Ljava/util/List;
    //   23: ifnull +55 -> 78
    //   26: aload_0
    //   27: getfield 157	com/tencent/mm/plugin/label/ui/a:Eej	Ljava/util/List;
    //   30: invokeinterface 163 1 0
    //   35: ifle +43 -> 78
    //   38: invokestatic 69	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   41: pop
    //   42: invokestatic 75	com/tencent/mm/model/c:bbL	()Lcom/tencent/mm/storage/bv;
    //   45: aload_0
    //   46: getfield 157	com/tencent/mm/plugin/label/ui/a:Eej	Ljava/util/List;
    //   49: invokeinterface 167 2 0
    //   54: astore_2
    //   55: iload_1
    //   56: ifeq +29 -> 85
    //   59: aload_0
    //   60: aload_2
    //   61: invokevirtual 170	com/tencent/mm/plugin/label/ui/a:m	(Landroid/database/Cursor;)V
    //   64: sipush 26254
    //   67: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: iconst_0
    //   74: istore_1
    //   75: goto -56 -> 19
    //   78: invokestatic 175	com/tencent/mm/storagebase/d:hBM	()Landroid/database/Cursor;
    //   81: astore_2
    //   82: goto -27 -> 55
    //   85: new 7	com/tencent/mm/plugin/label/ui/a$1
    //   88: dup
    //   89: aload_0
    //   90: aload_2
    //   91: invokespecial 178	com/tencent/mm/plugin/label/ui/a$1:<init>	(Lcom/tencent/mm/plugin/label/ui/a;Landroid/database/Cursor;)V
    //   94: invokestatic 184	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   97: sipush 26254
    //   100: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: goto -33 -> 70
    //   106: astore_2
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_2
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	a
    //   18	57	1	i	int
    //   54	37	2	localCursor	Cursor
    //   106	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	106	finally
    //   19	55	106	finally
    //   59	70	106	finally
    //   78	82	106	finally
    //   85	103	106	finally
  }
  
  public final void ats()
  {
    AppMethodBeat.i(26255);
    atr();
    AppMethodBeat.o(26255);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26251);
    int i = super.getCount();
    AppMethodBeat.o(26251);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(26253);
    as localas = VD(paramInt).contact;
    View localView;
    Object localObject2;
    float f;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localView = View.inflate(this.context, R.i.efw, null);
      paramViewGroup = new a(localView);
      localView.setTag(paramViewGroup);
      localObject1 = paramViewGroup.Eem;
      localObject2 = localas.field_username;
      f = com.tencent.mm.pluginsdk.ui.a.syM;
      paramView = ((com.tencent.mm.pluginsdk.ui.a.a)localObject1).getDrawable();
      if ((paramView == null) || (!(paramView instanceof com.tencent.mm.pluginsdk.ui.c))) {
        break label362;
      }
      paramView = (com.tencent.mm.pluginsdk.ui.c)paramView;
      label98:
      paramView.setTag((String)localObject2);
      ((com.tencent.mm.pluginsdk.ui.a.a)localObject1).setImageDrawable(paramView);
      ((com.tencent.mm.pluginsdk.ui.a.a)localObject1).doInvalidate();
      if (localas.field_verifyFlag == 0) {
        break label388;
      }
      paramView = az.a.ltt.uT(localas.field_verifyFlag);
      if (paramView == null) {
        break label377;
      }
      paramView = o.US(paramView);
      paramViewGroup.Eem.setMaskBitmap(paramView);
      label158:
      if (localas.field_deleteFlag != 1) {
        break label399;
      }
      paramViewGroup.Eem.setNickNameTextColor(Eei);
      label177:
      paramViewGroup.Eem.updateTextColors();
      paramViewGroup.Eem.setMergeCallback(null);
      paramView = localas.Vcw;
      if (paramView != null) {
        break label418;
      }
    }
    try
    {
      localObject2 = this.context;
      localObject1 = aa.PJ(localas.field_username);
      paramView = (View)localObject1;
      if ("".length() > 0)
      {
        paramView = (View)localObject1;
        if (!"".equals(localObject1))
        {
          paramView = new StringBuilder(32);
          paramView.append((String)localObject1);
          paramView.append("(");
          paramView.append("");
          paramView.append(")");
          paramView = paramView.toString();
        }
      }
      paramView = l.b((Context)localObject2, paramView, paramViewGroup.Eem.getNickNameSize());
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView = null;
      }
    }
    Object localObject1 = paramView;
    if (paramView == null) {
      localObject1 = "";
    }
    paramViewGroup.Eem.setName((CharSequence)localObject1);
    localas.Vcw = ((CharSequence)localObject1);
    for (;;)
    {
      paramViewGroup.Eem.updatePositionFlag();
      AppMethodBeat.o(26253);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label362:
      paramView = new com.tencent.mm.pluginsdk.ui.c((String)localObject2, f);
      break label98;
      label377:
      paramViewGroup.Eem.setMaskBitmap(null);
      break label158;
      label388:
      paramViewGroup.Eem.setMaskBitmap(null);
      break label158;
      label399:
      paramViewGroup.Eem.setNickNameTextColor(Eeh);
      break label177;
      label418:
      paramViewGroup.Eem.setName(paramView);
    }
  }
  
  public final void m(Cursor paramCursor)
  {
    AppMethodBeat.i(26257);
    eKd();
    v(paramCursor);
    notifyDataSetChanged();
    AppMethodBeat.o(26257);
  }
  
  protected static final class a
  {
    public AddressView Eem;
    
    public a(View paramView)
    {
      AppMethodBeat.i(26249);
      this.Eem = ((AddressView)paramView.findViewById(R.h.dNc));
      AppMethodBeat.o(26249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.a
 * JD-Core Version:    0.7.0.1
 */
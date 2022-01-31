package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.contact.f;
import com.tencent.mm.ui.p;
import java.util.List;
import java.util.Map;

public final class a
  extends p<f>
{
  public static final ColorStateList nYQ;
  public static final ColorStateList nYR;
  List<String> nYS;
  
  static
  {
    AppMethodBeat.i(22638);
    nYQ = com.tencent.mm.cb.a.l(ah.getContext(), 2131690768);
    nYR = com.tencent.mm.cb.a.l(ah.getContext(), 2131690168);
    AppMethodBeat.o(22638);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, new f());
    AppMethodBeat.i(22628);
    AppMethodBeat.o(22628);
  }
  
  private static f a(f paramf, Cursor paramCursor)
  {
    AppMethodBeat.i(22634);
    f localf = paramf;
    if (paramf == null) {
      localf = new f();
    }
    aw.aaz();
    paramf = c.YA().arq(ad.o(paramCursor));
    if (paramf == null)
    {
      localf.contact.convertFrom(paramCursor);
      aw.aaz();
      c.YA().V(localf.contact);
    }
    for (;;)
    {
      AppMethodBeat.o(22634);
      return localf;
      localf.contact = paramf;
    }
  }
  
  /* Error */
  public final void Ku()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 22632
    //   5: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 96	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   11: invokestatic 99	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   14: if_acmpne +59 -> 73
    //   17: iconst_1
    //   18: istore_1
    //   19: aload_0
    //   20: getfield 101	com/tencent/mm/plugin/label/ui/a:nYS	Ljava/util/List;
    //   23: ifnull +55 -> 78
    //   26: aload_0
    //   27: getfield 101	com/tencent/mm/plugin/label/ui/a:nYS	Ljava/util/List;
    //   30: invokeinterface 107 1 0
    //   35: ifle +43 -> 78
    //   38: invokestatic 60	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   41: pop
    //   42: invokestatic 66	com/tencent/mm/model/c:YA	()Lcom/tencent/mm/storage/bd;
    //   45: aload_0
    //   46: getfield 101	com/tencent/mm/plugin/label/ui/a:nYS	Ljava/util/List;
    //   49: invokeinterface 111 2 0
    //   54: astore_2
    //   55: iload_1
    //   56: ifeq +29 -> 85
    //   59: aload_0
    //   60: aload_2
    //   61: invokevirtual 114	com/tencent/mm/plugin/label/ui/a:j	(Landroid/database/Cursor;)V
    //   64: sipush 22632
    //   67: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: iconst_0
    //   74: istore_1
    //   75: goto -56 -> 19
    //   78: invokestatic 120	com/tencent/mm/cg/d:dzJ	()Landroid/database/Cursor;
    //   81: astore_2
    //   82: goto -27 -> 55
    //   85: new 122	com/tencent/mm/plugin/label/ui/a$1
    //   88: dup
    //   89: aload_0
    //   90: aload_2
    //   91: invokespecial 125	com/tencent/mm/plugin/label/ui/a$1:<init>	(Lcom/tencent/mm/plugin/label/ui/a;Landroid/database/Cursor;)V
    //   94: invokestatic 131	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   97: sipush 22632
    //   100: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void Kv()
  {
    AppMethodBeat.i(22633);
    Ku();
    AppMethodBeat.o(22633);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(22629);
    int i = super.getCount();
    AppMethodBeat.o(22629);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22631);
    ad localad = ya(paramInt).contact;
    View localView;
    Object localObject2;
    float f;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localView = View.inflate(this.context, 2130969261, null);
      paramViewGroup = new a.a(localView);
      localView.setTag(paramViewGroup);
      localObject1 = paramViewGroup.nYV;
      localObject2 = localad.field_username;
      f = com.tencent.mm.pluginsdk.ui.a.Iy();
      paramView = ((com.tencent.mm.pluginsdk.ui.a.a)localObject1).getDrawable();
      if ((paramView == null) || (!(paramView instanceof b))) {
        break label361;
      }
      paramView = (b)paramView;
      label97:
      paramView.setTag((String)localObject2);
      ((com.tencent.mm.pluginsdk.ui.a.a)localObject1).setImageDrawable(paramView);
      ((com.tencent.mm.pluginsdk.ui.a.a)localObject1).doInvalidate();
      if (localad.field_verifyFlag == 0) {
        break label387;
      }
      paramView = ao.a.flK.ky(localad.field_verifyFlag);
      if (paramView == null) {
        break label376;
      }
      paramView = m.sf(paramView);
      paramViewGroup.nYV.setMaskBitmap(paramView);
      label157:
      if (localad.field_deleteFlag != 1) {
        break label398;
      }
      paramViewGroup.nYV.setNickNameTextColor(nYR);
      label176:
      paramViewGroup.nYV.updateTextColors();
      paramViewGroup.nYV.setMergeCallback(null);
      paramView = localad.ywx;
      if (paramView != null) {
        break label417;
      }
    }
    try
    {
      localObject2 = this.context;
      localObject1 = s.nE(localad.field_username);
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
      paramView = j.b((Context)localObject2, paramView, paramViewGroup.nYV.getNickNameSize());
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
    paramViewGroup.nYV.setName((CharSequence)localObject1);
    localad.ywx = ((CharSequence)localObject1);
    for (;;)
    {
      paramViewGroup.nYV.updatePositionFlag();
      AppMethodBeat.o(22631);
      return localView;
      paramViewGroup = (a.a)paramView.getTag();
      localView = paramView;
      break;
      label361:
      paramView = new b((String)localObject2, f);
      break label97;
      label376:
      paramViewGroup.nYV.setMaskBitmap(null);
      break label157;
      label387:
      paramViewGroup.nYV.setMaskBitmap(null);
      break label157;
      label398:
      paramViewGroup.nYV.setNickNameTextColor(nYQ);
      break label176;
      label417:
      paramViewGroup.nYV.setName(paramView);
    }
  }
  
  public final void j(Cursor paramCursor)
  {
    AppMethodBeat.i(22635);
    bKb();
    setCursor(paramCursor);
    notifyDataSetChanged();
    AppMethodBeat.o(22635);
  }
  
  public final f ya(int paramInt)
  {
    AppMethodBeat.i(22630);
    if (xj(paramInt))
    {
      localf = (f)bHt();
      AppMethodBeat.o(22630);
      return localf;
    }
    if (this.zap != null)
    {
      localf = (f)this.zap.get(Integer.valueOf(paramInt));
      if (localf != null)
      {
        AppMethodBeat.o(22630);
        return localf;
      }
    }
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt)))
    {
      AppMethodBeat.o(22630);
      return null;
    }
    f localf = a(null, getCursor());
    if (this.zap == null) {
      qp(true);
    }
    if (this.zap != null) {
      this.zap.put(Integer.valueOf(paramInt), localf);
    }
    AppMethodBeat.o(22630);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.a
 * JD-Core Version:    0.7.0.1
 */
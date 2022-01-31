package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R.e;
import com.tencent.mm.R.i;
import com.tencent.mm.ai.m;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.c;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.contact.f;
import java.util.List;
import java.util.Map;

public final class a
  extends com.tencent.mm.ui.r<f>
{
  public static final ColorStateList lBE = com.tencent.mm.cb.a.h(ae.getContext(), R.e.mm_list_textcolor_one);
  public static final ColorStateList lBF = com.tencent.mm.cb.a.h(ae.getContext(), R.e.hint_text_color);
  List<String> lBG;
  
  public a(Context paramContext)
  {
    super(paramContext, new f());
  }
  
  private static f a(f paramf, Cursor paramCursor)
  {
    f localf = paramf;
    if (paramf == null) {
      localf = new f();
    }
    au.Hx();
    paramf = c.Fw().abf(ad.n(paramCursor));
    if (paramf == null)
    {
      localf.dnp.d(paramCursor);
      au.Hx();
      c.Fw().S(localf.dnp);
      return localf;
    }
    localf.dnp = paramf;
    return localf;
  }
  
  public final int getCount()
  {
    return super.getCount();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    localObject = null;
    ad localad = sX(paramInt).dnp;
    View localView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localView = View.inflate(this.context, R.i.contact_label_member_list_item, null);
      paramViewGroup = new a.a(localView);
      localView.setTag(paramViewGroup);
      a.b.a(paramViewGroup.lBJ, localad.field_username);
      if (localad.field_verifyFlag == 0) {
        break label305;
      }
      paramView = am.a.dVA.hM(localad.field_verifyFlag);
      if (paramView == null) {
        break label294;
      }
      paramView = m.lk(paramView);
      paramViewGroup.lBJ.setMaskBitmap(paramView);
      label104:
      if (localad.field_deleteFlag != 1) {
        break label316;
      }
      paramViewGroup.lBJ.setNickNameTextColor(lBF);
      label123:
      paramViewGroup.lBJ.updateTextColors();
      paramView = localad.umR;
      if (paramView != null) {
        break label329;
      }
    }
    try
    {
      Context localContext = this.context;
      paramView = localad.field_username;
      String str = com.tencent.mm.model.r.gV(localad.field_username);
      paramView = str;
      if ("".length() > 0)
      {
        paramView = str;
        if (!"".equals(str))
        {
          paramView = new StringBuilder(32);
          paramView.append(str);
          paramView.append("(");
          paramView.append("");
          paramView.append(")");
          paramView = paramView.toString();
        }
      }
      paramView = j.a(localContext, paramView, paramViewGroup.lBJ.getNickNameSize());
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        label294:
        label305:
        label316:
        label329:
        paramView = (View)localObject;
      }
    }
    localObject = paramView;
    if (paramView == null) {
      localObject = "";
    }
    paramViewGroup.lBJ.setName((CharSequence)localObject);
    localad.umR = ((CharSequence)localObject);
    for (;;)
    {
      paramViewGroup.lBJ.updatePositionFlag();
      return localView;
      paramViewGroup = (a.a)paramView.getTag();
      localView = paramView;
      break;
      paramViewGroup.lBJ.setMaskBitmap(null);
      break label104;
      paramViewGroup.lBJ.setMaskBitmap(null);
      break label104;
      paramViewGroup.lBJ.setNickNameTextColor(lBE);
      break label123;
      paramViewGroup.lBJ.setName(paramView);
    }
  }
  
  public final void k(Cursor paramCursor)
  {
    bcS();
    setCursor(paramCursor);
    notifyDataSetChanged();
  }
  
  public final f sX(int paramInt)
  {
    Object localObject;
    if (sk(paramInt)) {
      localObject = (f)ban();
    }
    f localf;
    do
    {
      do
      {
        return localObject;
        if (this.uMh == null) {
          break;
        }
        localf = (f)this.uMh.get(Integer.valueOf(paramInt));
        localObject = localf;
      } while (localf != null);
      if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt))) {
        return null;
      }
      localf = a(null, getCursor());
      if (this.uMh == null) {
        mR(true);
      }
      localObject = localf;
    } while (this.uMh == null);
    this.uMh.put(Integer.valueOf(paramInt), localf);
    return localf;
  }
  
  /* Error */
  public final void yc()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 294	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   5: invokestatic 297	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   8: if_acmpne +53 -> 61
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: getfield 299	com/tencent/mm/plugin/label/ui/a:lBG	Ljava/util/List;
    //   17: ifnull +49 -> 66
    //   20: aload_0
    //   21: getfield 299	com/tencent/mm/plugin/label/ui/a:lBG	Ljava/util/List;
    //   24: invokeinterface 304 1 0
    //   29: ifle +37 -> 66
    //   32: invokestatic 58	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   35: pop
    //   36: invokestatic 64	com/tencent/mm/model/c:Fw	()Lcom/tencent/mm/storage/bd;
    //   39: aload_0
    //   40: getfield 299	com/tencent/mm/plugin/label/ui/a:lBG	Ljava/util/List;
    //   43: invokeinterface 308 2 0
    //   48: astore_2
    //   49: iload_1
    //   50: ifeq +23 -> 73
    //   53: aload_0
    //   54: aload_2
    //   55: invokevirtual 310	com/tencent/mm/plugin/label/ui/a:k	(Landroid/database/Cursor;)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: iconst_0
    //   62: istore_1
    //   63: goto -50 -> 13
    //   66: invokestatic 315	com/tencent/mm/cf/d:cwX	()Landroid/database/Cursor;
    //   69: astore_2
    //   70: goto -21 -> 49
    //   73: new 317	com/tencent/mm/plugin/label/ui/a$1
    //   76: dup
    //   77: aload_0
    //   78: aload_2
    //   79: invokespecial 320	com/tencent/mm/plugin/label/ui/a$1:<init>	(Lcom/tencent/mm/plugin/label/ui/a;Landroid/database/Cursor;)V
    //   82: invokestatic 325	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   85: goto -27 -> 58
    //   88: astore_2
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_2
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	a
    //   12	51	1	i	int
    //   48	31	2	localCursor	Cursor
    //   88	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	88	finally
    //   13	49	88	finally
    //   53	58	88	finally
    //   66	70	88	finally
    //   73	85	88	finally
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.a
 * JD-Core Version:    0.7.0.1
 */
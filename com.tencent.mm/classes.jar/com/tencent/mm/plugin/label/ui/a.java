package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.o;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.contact.f;
import com.tencent.mm.ui.r;
import java.util.List;
import java.util.Map;

public final class a
  extends r<f>
{
  public static final ColorStateList viK;
  public static final ColorStateList viL;
  List<String> viM;
  
  static
  {
    AppMethodBeat.i(26260);
    viK = com.tencent.mm.cb.a.m(ak.getContext(), 2131100638);
    viL = com.tencent.mm.cb.a.m(ak.getContext(), 2131100490);
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
    bc.aCg();
    paramf = com.tencent.mm.model.c.azF().aUG(an.p(paramCursor));
    if (paramf == null)
    {
      localf.contact.convertFrom(paramCursor);
      bc.aCg();
      com.tencent.mm.model.c.azF().ak(localf.contact);
    }
    for (;;)
    {
      AppMethodBeat.o(26256);
      return localf;
      localf.contact = paramf;
    }
  }
  
  public final f Jr(int paramInt)
  {
    AppMethodBeat.i(26252);
    if (Iw(paramInt))
    {
      localf = (f)dcP();
      AppMethodBeat.o(26252);
      return localf;
    }
    if (this.Jvm != null)
    {
      localf = (f)this.Jvm.get(Integer.valueOf(paramInt));
      if (localf != null)
      {
        AppMethodBeat.o(26252);
        return localf;
      }
    }
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt)))
    {
      AppMethodBeat.o(26252);
      return null;
    }
    f localf = a(null, getCursor());
    if (this.Jvm == null) {
      xs(true);
    }
    if (this.Jvm != null) {
      this.Jvm.put(Integer.valueOf(paramInt), localf);
    }
    AppMethodBeat.o(26252);
    return localf;
  }
  
  /* Error */
  public final void ZD()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 26254
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 144	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   11: invokestatic 147	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   14: if_acmpne +59 -> 73
    //   17: iconst_1
    //   18: istore_1
    //   19: aload_0
    //   20: getfield 149	com/tencent/mm/plugin/label/ui/a:viM	Ljava/util/List;
    //   23: ifnull +55 -> 78
    //   26: aload_0
    //   27: getfield 149	com/tencent/mm/plugin/label/ui/a:viM	Ljava/util/List;
    //   30: invokeinterface 155 1 0
    //   35: ifle +43 -> 78
    //   38: invokestatic 62	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
    //   41: pop
    //   42: invokestatic 68	com/tencent/mm/model/c:azF	()Lcom/tencent/mm/storage/bq;
    //   45: aload_0
    //   46: getfield 149	com/tencent/mm/plugin/label/ui/a:viM	Ljava/util/List;
    //   49: invokeinterface 159 2 0
    //   54: astore_2
    //   55: iload_1
    //   56: ifeq +29 -> 85
    //   59: aload_0
    //   60: aload_2
    //   61: invokevirtual 162	com/tencent/mm/plugin/label/ui/a:j	(Landroid/database/Cursor;)V
    //   64: sipush 26254
    //   67: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: iconst_0
    //   74: istore_1
    //   75: goto -56 -> 19
    //   78: invokestatic 167	com/tencent/mm/storagebase/d:fxH	()Landroid/database/Cursor;
    //   81: astore_2
    //   82: goto -27 -> 55
    //   85: new 7	com/tencent/mm/plugin/label/ui/a$1
    //   88: dup
    //   89: aload_0
    //   90: aload_2
    //   91: invokespecial 170	com/tencent/mm/plugin/label/ui/a$1:<init>	(Lcom/tencent/mm/plugin/label/ui/a;Landroid/database/Cursor;)V
    //   94: invokestatic 176	com/tencent/mm/sdk/platformtools/ar:f	(Ljava/lang/Runnable;)V
    //   97: sipush 26254
    //   100: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void ZE()
  {
    AppMethodBeat.i(26255);
    ZD();
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
    an localan = Jr(paramInt).contact;
    View localView;
    Object localObject2;
    float f;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localView = View.inflate(this.context, 2131493649, null);
      paramViewGroup = new a(localView);
      localView.setTag(paramViewGroup);
      localObject1 = paramViewGroup.viP;
      localObject2 = localan.field_username;
      f = com.tencent.mm.pluginsdk.ui.a.oeP;
      paramView = ((com.tencent.mm.pluginsdk.ui.a.a)localObject1).getDrawable();
      if ((paramView == null) || (!(paramView instanceof com.tencent.mm.pluginsdk.ui.c))) {
        break label361;
      }
      paramView = (com.tencent.mm.pluginsdk.ui.c)paramView;
      label97:
      paramView.setTag((String)localObject2);
      ((com.tencent.mm.pluginsdk.ui.a.a)localObject1).setImageDrawable(paramView);
      ((com.tencent.mm.pluginsdk.ui.a.a)localObject1).doInvalidate();
      if (localan.field_verifyFlag == 0) {
        break label387;
      }
      paramView = au.a.hII.ov(localan.field_verifyFlag);
      if (paramView == null) {
        break label376;
      }
      paramView = o.EI(paramView);
      paramViewGroup.viP.setMaskBitmap(paramView);
      label157:
      if (localan.field_deleteFlag != 1) {
        break label398;
      }
      paramViewGroup.viP.setNickNameTextColor(viL);
      label176:
      paramViewGroup.viP.updateTextColors();
      paramViewGroup.viP.setMergeCallback(null);
      paramView = localan.IHU;
      if (paramView != null) {
        break label417;
      }
    }
    try
    {
      localObject2 = this.context;
      localObject1 = w.zP(localan.field_username);
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
      paramView = k.b((Context)localObject2, paramView, paramViewGroup.viP.getNickNameSize());
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
    paramViewGroup.viP.setName((CharSequence)localObject1);
    localan.IHU = ((CharSequence)localObject1);
    for (;;)
    {
      paramViewGroup.viP.updatePositionFlag();
      AppMethodBeat.o(26253);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label361:
      paramView = new com.tencent.mm.pluginsdk.ui.c((String)localObject2, f);
      break label97;
      label376:
      paramViewGroup.viP.setMaskBitmap(null);
      break label157;
      label387:
      paramViewGroup.viP.setMaskBitmap(null);
      break label157;
      label398:
      paramViewGroup.viP.setNickNameTextColor(viK);
      break label176;
      label417:
      paramViewGroup.viP.setName(paramView);
    }
  }
  
  public final void j(Cursor paramCursor)
  {
    AppMethodBeat.i(26257);
    dhl();
    setCursor(paramCursor);
    notifyDataSetChanged();
    AppMethodBeat.o(26257);
  }
  
  protected static final class a
  {
    public AddressView viP;
    
    public a(View paramView)
    {
      AppMethodBeat.i(26249);
      this.viP = ((AddressView)paramView.findViewById(2131302653));
      AppMethodBeat.o(26249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.a
 * JD-Core Version:    0.7.0.1
 */
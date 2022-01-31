package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.protocal.protobuf.cpn;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

final class ExdeviceRankDataSourceUI$b
  extends BaseAdapter
{
  private c lKi;
  List<ExdeviceRankDataSourceUI.a> lOV;
  
  public ExdeviceRankDataSourceUI$b()
  {
    AppMethodBeat.i(20117);
    this.lOV = new LinkedList();
    c.a locala = new c.a();
    locala.eNY = 2130838674;
    this.lKi = locala.ahY();
    AppMethodBeat.o(20117);
  }
  
  private ExdeviceRankDataSourceUI.a vh(int paramInt)
  {
    AppMethodBeat.i(20121);
    ExdeviceRankDataSourceUI.a locala = (ExdeviceRankDataSourceUI.a)this.lOV.get(paramInt);
    AppMethodBeat.o(20121);
    return locala;
  }
  
  /* Error */
  public final ExdeviceRankDataSourceUI.a LT(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 20118
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokestatic 65	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifne +55 -> 67
    //   15: aload_0
    //   16: getfield 29	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$b:lOV	Ljava/util/List;
    //   19: invokeinterface 69 1 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 75 1 0
    //   31: ifeq +36 -> 67
    //   34: aload_3
    //   35: invokeinterface 79 1 0
    //   40: checkcast 57	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$a
    //   43: astore_2
    //   44: aload_1
    //   45: aload_2
    //   46: getfield 83	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$a:mac	Ljava/lang/String;
    //   49: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifeq -27 -> 25
    //   55: sipush 20118
    //   58: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aload_2
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: areturn
    //   67: aconst_null
    //   68: astore_1
    //   69: sipush 20118
    //   72: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: goto -12 -> 63
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	b
    //   0	83	1	paramString	java.lang.String
    //   43	19	2	locala	ExdeviceRankDataSourceUI.a
    //   24	11	3	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   2	25	78	finally
    //   25	61	78	finally
    //   69	75	78	finally
  }
  
  /* Error */
  public final ExdeviceRankDataSourceUI.a dY(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 20119
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 29	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$b:lOV	Ljava/util/List;
    //   12: invokeinterface 69 1 0
    //   17: astore 4
    //   19: aload 4
    //   21: invokeinterface 75 1 0
    //   26: ifeq +42 -> 68
    //   29: aload 4
    //   31: invokeinterface 79 1 0
    //   36: checkcast 57	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$a
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull -22 -> 19
    //   44: aload_1
    //   45: aload_2
    //   46: aload_3
    //   47: getfield 95	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI$a:lOT	Lcom/tencent/mm/protocal/protobuf/cpn;
    //   50: invokestatic 99	com/tencent/mm/plugin/exdevice/ui/ExdeviceRankDataSourceUI:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/cpn;)Z
    //   53: ifeq -34 -> 19
    //   56: sipush 20119
    //   59: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_3
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: areturn
    //   68: aconst_null
    //   69: astore_1
    //   70: sipush 20119
    //   73: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: goto -12 -> 64
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	b
    //   0	84	1	paramString1	java.lang.String
    //   0	84	2	paramString2	java.lang.String
    //   39	24	3	locala	ExdeviceRankDataSourceUI.a
    //   17	13	4	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   2	19	79	finally
    //   19	40	79	finally
    //   44	62	79	finally
    //   70	76	79	finally
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(20120);
    int i = this.lOV.size();
    AppMethodBeat.o(20120);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(20122);
    ExdeviceRankDataSourceUI.a locala = vh(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new ExdeviceRankDataSourceUI.b.a((byte)0);
      localObject = View.inflate(paramViewGroup.getContext(), 2130969469, null);
      paramView.gzk = ((TextView)((View)localObject).findViewById(2131823741));
      paramView.ivs = ((ImageView)((View)localObject).findViewById(2131823740));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = ExdeviceRankDataSourceUI.a(locala);
      ab.d("MicroMsg.ExdeviceRankDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), localObject, locala.mac });
      paramViewGroup.gzk.setText((CharSequence)localObject);
      o.ahG().a(locala.lOT.IconUrl, paramViewGroup.ivs, this.lKi);
      AppMethodBeat.o(20122);
      return paramView;
      paramViewGroup = (ExdeviceRankDataSourceUI.b.a)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.b
 * JD-Core Version:    0.7.0.1
 */
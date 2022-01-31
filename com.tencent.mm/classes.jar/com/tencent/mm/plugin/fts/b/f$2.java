package com.tencent.mm.plugin.fts.b;

import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class f$2
  implements com.tencent.mm.ah.f
{
  f$2(f paramf) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof f.c))
    {
      paramm = (f.c)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label186;
      }
      y.e("MicroMsg.FTS.FTSSearchTestLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      List localList = paramm.rTv;
      if (paramInt2 == -44)
      {
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        HashMap localHashMap = new HashMap();
        localHashMap.put(localList.get(0), Integer.valueOf(0));
        paramm = new f.c(this.kzE, localList, localLinkedList, "你好，我是珍惜", paramm.kzG, localHashMap, paramm.kzG);
        g.Dk().a(paramm, 0);
      }
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!bk.bl(paramString))) {
        Toast.makeText(ae.getContext(), paramString, 1).show();
      }
    }
    return;
    label186:
    y.i("MicroMsg.FTS.FTSSearchTestLogic", "bind contact %s success", new Object[] { paramm.rTv.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.f.2
 * JD-Core Version:    0.7.0.1
 */
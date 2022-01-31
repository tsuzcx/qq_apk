package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i$a
{
  public String desc;
  public String mxW;
  public String thumbPath;
  public String title;
  
  private static boolean Oa(String paramString)
  {
    AppMethodBeat.i(74126);
    boolean bool = new com.tencent.mm.vfs.b(paramString).exists();
    AppMethodBeat.o(74126);
    return bool;
  }
  
  public static a a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74127);
    int j;
    Object localObject1;
    Object localObject2;
    if (paramg.field_type == 18)
    {
      locala = new a();
      localSparseIntArray = new SparseIntArray();
      if (paramg.field_type == 18) {
        locala.title = paramg.field_favProto.title;
      }
      i = 0;
      localLinkedList = new LinkedList();
      localIterator = paramg.field_favProto.wVc.iterator();
      j = 0;
      while (localIterator.hasNext())
      {
        localObject1 = (aca)localIterator.next();
        if ((paramg.field_type != 18) || (bo.isNullOrNil(((aca)localObject1).wSR)) || (!((aca)localObject1).wSR.equals(".htm")))
        {
          int k = localSparseIntArray.get(((aca)localObject1).dataType);
          localSparseIntArray.put(((aca)localObject1).dataType, k + 1);
          switch (((aca)localObject1).dataType)
          {
          case 5: 
          case 7: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 18: 
          default: 
            break;
          case 1: 
            if (localLinkedList.size() < 4)
            {
              localObject1 = ((aca)localObject1).desc;
              if (!bo.isNullOrNil((String)localObject1))
              {
                localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                localLinkedList.add((String)localObject1 + "\n");
              }
            }
            break;
          case 3: 
            if (localLinkedList.size() < 4)
            {
              k = (int)com.tencent.mm.plugin.fav.a.b.jR(((aca)localObject1).duration);
              localLinkedList.add(paramContext.getString(2131297105) + paramContext.getString(2131299675, new Object[] { Integer.valueOf(k) }) + "\n");
            }
            break;
          case 2: 
            if (j == 0)
            {
              localObject2 = com.tencent.mm.plugin.fav.a.b.c((aca)localObject1);
              if (Oa((String)localObject2))
              {
                locala.thumbPath = ((String)localObject2);
                j = 1;
              }
              else
              {
                locala.thumbPath = com.tencent.mm.plugin.fav.a.b.b((aca)localObject1);
                j = 1;
              }
            }
            break;
          case 6: 
            if (localLinkedList.size() < 4)
            {
              localObject1 = ((aca)localObject1).wTw.wUd;
              localObject2 = new StringBuilder().append(paramContext.getString(2131296989));
              if ((!bo.isNullOrNil(((ach)localObject1).cDl)) && (!((ach)localObject1).cDl.equals(paramContext.getString(2131301115)))) {
                break label565;
              }
            }
            for (localObject1 = ((ach)localObject1).label;; localObject1 = ((ach)localObject1).cDl)
            {
              localLinkedList.add((String)localObject1 + "\n");
              if (i != 0) {
                break;
              }
              i = 1;
              break;
            }
          case 8: 
            if (localLinkedList.size() < 4) {
              localLinkedList.add(paramContext.getString(2131296962) + ((aca)localObject1).title + "\n");
            }
            if (i == 0) {
              i = 1;
            }
            break;
          case 4: 
            if (localLinkedList.size() < 4) {
              localLinkedList.add(paramContext.getString(2131297102) + "\n");
            }
            break;
          case 17: 
            if (localLinkedList.size() < 4) {
              localLinkedList.add(paramContext.getString(2131297055) + "\n");
            }
            break;
          case 19: 
            label565:
            if (localLinkedList.size() < 4) {
              localLinkedList.add(paramContext.getString(2131296544) + ((aca)localObject1).title + "\n");
            }
            break;
          }
        }
      }
      locala.desc = "";
      paramg = localLinkedList.iterator();
      for (paramContext = ""; paramg.hasNext(); paramContext = paramContext + (String)localObject1) {
        localObject1 = (String)paramg.next();
      }
      paramg = paramContext.trim();
      paramContext = paramg;
      if (localLinkedList.size() >= 4) {
        paramContext = paramg + "...";
      }
      locala.desc = paramContext;
      if (locala.title == null) {
        locala.title = "";
      }
      AppMethodBeat.o(74127);
      return locala;
    }
    a locala = new a();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    if (paramg.field_type == 14) {
      locala.title = paramg.field_favProto.title;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramg.field_favProto.wVc.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      localObject2 = (aca)localIterator.next();
      j = localSparseIntArray.get(((aca)localObject2).dataType);
      localSparseIntArray.put(((aca)localObject2).dataType, j + 1);
      switch (((aca)localObject2).dataType)
      {
      case 9: 
      case 12: 
      case 13: 
      case 18: 
      default: 
        break;
      case 1: 
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((aca)localObject2).wTy + ":" + ((aca)localObject2).desc + "\n");
        }
        break;
      case 3: 
        if (localLinkedList.size() < 4)
        {
          j = (int)com.tencent.mm.plugin.fav.a.b.hi(((aca)localObject2).duration);
          localLinkedList.add(((aca)localObject2).wTy + ":" + paramContext.getString(2131297105) + paramContext.getString(2131299675, new Object[] { Integer.valueOf(j) }) + "\n");
        }
        break;
      case 2: 
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((aca)localObject2).wTy + ":" + paramContext.getString(2131297036) + "\n");
        }
        if (i == 0)
        {
          paramg = com.tencent.mm.plugin.fav.a.b.c((aca)localObject2);
          if (!Oa(paramg)) {
            break label2550;
          }
          locala.thumbPath = paramg;
          i = 1;
        }
        break;
      }
    }
    label1780:
    label2550:
    for (;;)
    {
      break;
      if (localLinkedList.size() < 4) {
        localLinkedList.add(((aca)localObject2).wTy + ":" + paramContext.getString(2131297097) + ((aca)localObject2).title + "\n");
      }
      if (i != 0) {
        break;
      }
      paramg = com.tencent.mm.plugin.fav.a.b.c((aca)localObject2);
      if (Oa(paramg))
      {
        locala.thumbPath = paramg;
        i = 1;
        break;
      }
      paramg = ((aca)localObject2).wTw.wUf;
      if (paramg == null) {}
      for (paramg = "";; paramg = paramg.thumbUrl)
      {
        localObject1 = paramg;
        if (bo.isNullOrNil(paramg)) {
          localObject1 = bo.bf(((aca)localObject2).cpH, "");
        }
        a(locala, (String)localObject1);
        break;
      }
      if (localLinkedList.size() < 4) {
        localLinkedList.add(((aca)localObject2).wTy + ":" + paramContext.getString(2131297077) + "\n");
      }
      if (i != 0) {
        break;
      }
      paramg = com.tencent.mm.plugin.fav.a.b.c((aca)localObject2);
      if (Oa(paramg))
      {
        locala.thumbPath = paramg;
        i = 1;
      }
      for (;;)
      {
        break;
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((aca)localObject2).wTy + ":" + paramContext.getString(2131297102) + "\n");
        }
        if (i != 0) {
          break;
        }
        paramg = com.tencent.mm.plugin.fav.a.b.c((aca)localObject2);
        if (Oa(paramg))
        {
          locala.thumbPath = paramg;
          i = 1;
        }
        for (;;)
        {
          break;
          if (localLinkedList.size() < 4)
          {
            paramg = ((aca)localObject2).wTw.wUd;
            localObject1 = new StringBuilder().append(((aca)localObject2).wTy).append(":").append(paramContext.getString(2131296989));
            if ((!bo.isNullOrNil(paramg.cDl)) && (!paramg.cDl.equals(paramContext.getString(2131301115)))) {
              break label1780;
            }
          }
          for (paramg = paramg.label;; paramg = paramg.cDl)
          {
            localLinkedList.add(paramg + "\n");
            if (i != 0) {
              break;
            }
            i = 1;
            break;
          }
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((aca)localObject2).wTy + ":" + paramContext.getString(2131297003) + ((aca)localObject2).title + "\n");
          }
          if (i != 0) {
            break;
          }
          a(locala, ((aca)localObject2).cpH);
          i = 1;
          break;
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((aca)localObject2).wTy + ":" + paramContext.getString(2131296962) + ((aca)localObject2).title + "\n");
          }
          if (i != 0) {
            break;
          }
          i = 1;
          break;
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((aca)localObject2).wTy + ":" + paramContext.getString(2131297041) + ((aca)localObject2).wTw.wUh.title + "\n");
          }
          if (i != 0) {
            break;
          }
          paramg = ((aca)localObject2).wTw.wUh;
          if (paramg != null) {
            a(locala, paramg.thumbUrl);
          }
          i = 1;
          break;
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((aca)localObject2).wTy + ":" + paramContext.getString(2131296543) + "\n");
          }
          if (i != 0) {
            break;
          }
          paramg = ((aca)localObject2).wTw.wUj;
          if (paramg != null) {
            a(locala, paramg.thumbUrl);
          }
          i = 1;
          break;
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((aca)localObject2).wTy + ":" + paramContext.getString(2131296967) + "\n");
          }
          if (i != 0) {
            break;
          }
          locala.mxW = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Ty(((aca)localObject2).desc).tac;
          i = 1;
          break;
          if (localLinkedList.size() >= 4) {
            break;
          }
          localLinkedList.add(((aca)localObject2).wTy + ":" + paramContext.getString(2131297055) + "\n");
          break;
          if (localLinkedList.size() >= 4) {
            break;
          }
          if ((((aca)localObject2).wTw.wUs != null) && (((aca)localObject2).wTw.wUs.type == 3))
          {
            localLinkedList.add(((aca)localObject2).wTy + ":" + paramContext.getString(2131297016) + "\n");
            break;
          }
          localLinkedList.add(((aca)localObject2).wTy + ":" + paramContext.getString(2131296544) + ((aca)localObject2).title + "\n");
          break;
          locala.desc = "";
          paramg = localLinkedList.iterator();
          for (paramContext = ""; paramg.hasNext(); paramContext = paramContext + (String)localObject1) {
            localObject1 = (String)paramg.next();
          }
          paramg = paramContext.trim();
          paramContext = paramg;
          if (localLinkedList.size() >= 4) {
            paramContext = paramg + "...";
          }
          locala.desc = paramContext;
          AppMethodBeat.o(74127);
          return locala;
        }
      }
    }
  }
  
  private static void a(a parama, String paramString)
  {
    AppMethodBeat.i(74128);
    paramString = com.tencent.mm.plugin.fav.a.b.bvW() + com.tencent.mm.a.g.w(bo.bf(paramString, "").getBytes());
    if (Oa(paramString)) {
      parama.thumbPath = paramString;
    }
    AppMethodBeat.o(74128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.i.a
 * JD-Core Version:    0.7.0.1
 */
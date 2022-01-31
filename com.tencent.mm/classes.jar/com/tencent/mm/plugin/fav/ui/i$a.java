package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.util.SparseIntArray;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i$a
{
  public String desc;
  public String kdm;
  public String thumbPath;
  public String title;
  
  private static boolean CY(String paramString)
  {
    return new com.tencent.mm.vfs.b(paramString).exists();
  }
  
  public static a a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg)
  {
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
      localLinkedList = new LinkedList();
      localIterator = paramg.field_favProto.sXc.iterator();
      j = 0;
      i = 0;
      while (localIterator.hasNext())
      {
        localObject1 = (xv)localIterator.next();
        if ((paramg.field_type != 18) || (bk.bl(((xv)localObject1).sUV)) || (!((xv)localObject1).sUV.equals(".htm")))
        {
          int k = localSparseIntArray.get(((xv)localObject1).aYU);
          localSparseIntArray.put(((xv)localObject1).aYU, k + 1);
          switch (((xv)localObject1).aYU)
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
              localObject1 = ((xv)localObject1).desc;
              if (!bk.bl((String)localObject1))
              {
                localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                localLinkedList.add((String)localObject1 + "\n");
              }
            }
            break;
          case 3: 
            if (localLinkedList.size() < 4)
            {
              k = (int)com.tencent.mm.plugin.fav.a.b.eu(((xv)localObject1).duration);
              localLinkedList.add(paramContext.getString(n.i.app_voice) + paramContext.getString(n.i.fav_fmt_time_length, new Object[] { Integer.valueOf(k) }) + "\n");
            }
            break;
          case 2: 
            if (j == 0)
            {
              localObject2 = com.tencent.mm.plugin.fav.a.b.c((xv)localObject1);
              if (CY((String)localObject2))
              {
                locala.thumbPath = ((String)localObject2);
                j = 1;
              }
              else
              {
                locala.thumbPath = com.tencent.mm.plugin.fav.a.b.b((xv)localObject1);
                j = 1;
              }
            }
            break;
          case 6: 
            if (localLinkedList.size() < 4)
            {
              localObject1 = ((xv)localObject1).sVA.sWf;
              localObject2 = new StringBuilder().append(paramContext.getString(n.i.app_location));
              if ((!bk.bl(((yc)localObject1).bVA)) && (!((yc)localObject1).bVA.equals(paramContext.getString(n.i.location_sub_title_location_with_bracket)))) {
                break label565;
              }
            }
            for (localObject1 = ((yc)localObject1).label;; localObject1 = ((yc)localObject1).bVA)
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
              localLinkedList.add(paramContext.getString(n.i.app_file) + ((xv)localObject1).title + "\n");
            }
            if (i == 0) {
              i = 1;
            }
            break;
          case 4: 
            if (localLinkedList.size() < 4) {
              localLinkedList.add(paramContext.getString(n.i.app_video) + "\n");
            }
            break;
          case 17: 
            if (localLinkedList.size() < 4) {
              localLinkedList.add(paramContext.getString(n.i.app_record) + "\n");
            }
            break;
          case 19: 
            label565:
            if (localLinkedList.size() < 4) {
              localLinkedList.add(paramContext.getString(n.i.app_app_brand) + ((xv)localObject1).title + "\n");
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
      return locala;
    }
    a locala = new a();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    if (paramg.field_type == 14) {
      locala.title = paramg.field_favProto.title;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramg.field_favProto.sXc.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      localObject2 = (xv)localIterator.next();
      j = localSparseIntArray.get(((xv)localObject2).aYU);
      localSparseIntArray.put(((xv)localObject2).aYU, j + 1);
      switch (((xv)localObject2).aYU)
      {
      case 9: 
      case 12: 
      case 13: 
      case 18: 
      default: 
        break;
      case 1: 
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((xv)localObject2).sVC + ":" + ((xv)localObject2).desc + "\n");
        }
        break;
      case 3: 
        if (localLinkedList.size() < 4)
        {
          j = (int)com.tencent.mm.plugin.fav.a.b.ck(((xv)localObject2).duration);
          localLinkedList.add(((xv)localObject2).sVC + ":" + paramContext.getString(n.i.app_voice) + paramContext.getString(n.i.fav_fmt_time_length, new Object[] { Integer.valueOf(j) }) + "\n");
        }
        break;
      case 2: 
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((xv)localObject2).sVC + ":" + paramContext.getString(n.i.app_pic) + "\n");
        }
        if (i == 0)
        {
          paramg = com.tencent.mm.plugin.fav.a.b.c((xv)localObject2);
          if (!CY(paramg)) {
            break label2555;
          }
          locala.thumbPath = paramg;
          i = 1;
        }
        break;
      }
    }
    label1784:
    label2555:
    for (;;)
    {
      break;
      if (localLinkedList.size() < 4) {
        localLinkedList.add(((xv)localObject2).sVC + ":" + paramContext.getString(n.i.app_url) + ((xv)localObject2).title + "\n");
      }
      if (i != 0) {
        break;
      }
      paramg = com.tencent.mm.plugin.fav.a.b.c((xv)localObject2);
      if (CY(paramg))
      {
        locala.thumbPath = paramg;
        i = 1;
        break;
      }
      paramg = ((xv)localObject2).sVA.sWh;
      if (paramg == null) {}
      for (paramg = "";; paramg = paramg.thumbUrl)
      {
        localObject1 = paramg;
        if (bk.bl(paramg)) {
          localObject1 = bk.aM(((xv)localObject2).bIm, "");
        }
        a(locala, (String)localObject1);
        break;
      }
      if (localLinkedList.size() < 4) {
        localLinkedList.add(((xv)localObject2).sVC + ":" + paramContext.getString(n.i.app_shortvideo) + "\n");
      }
      if (i != 0) {
        break;
      }
      paramg = com.tencent.mm.plugin.fav.a.b.c((xv)localObject2);
      if (CY(paramg))
      {
        locala.thumbPath = paramg;
        i = 1;
      }
      for (;;)
      {
        break;
        if (localLinkedList.size() < 4) {
          localLinkedList.add(((xv)localObject2).sVC + ":" + paramContext.getString(n.i.app_video) + "\n");
        }
        if (i != 0) {
          break;
        }
        paramg = com.tencent.mm.plugin.fav.a.b.c((xv)localObject2);
        if (CY(paramg))
        {
          locala.thumbPath = paramg;
          i = 1;
        }
        for (;;)
        {
          break;
          if (localLinkedList.size() < 4)
          {
            paramg = ((xv)localObject2).sVA.sWf;
            localObject1 = new StringBuilder().append(((xv)localObject2).sVC).append(":").append(paramContext.getString(n.i.app_location));
            if ((!bk.bl(paramg.bVA)) && (!paramg.bVA.equals(paramContext.getString(n.i.location_sub_title_location_with_bracket)))) {
              break label1784;
            }
          }
          for (paramg = paramg.label;; paramg = paramg.bVA)
          {
            localLinkedList.add(paramg + "\n");
            if (i != 0) {
              break;
            }
            i = 1;
            break;
          }
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((xv)localObject2).sVC + ":" + paramContext.getString(n.i.app_music) + ((xv)localObject2).title + "\n");
          }
          if (i != 0) {
            break;
          }
          a(locala, ((xv)localObject2).bIm);
          i = 1;
          break;
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((xv)localObject2).sVC + ":" + paramContext.getString(n.i.app_file) + ((xv)localObject2).title + "\n");
          }
          if (i != 0) {
            break;
          }
          i = 1;
          break;
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((xv)localObject2).sVC + ":" + paramContext.getString(n.i.app_product) + ((xv)localObject2).sVA.sWj.title + "\n");
          }
          if (i != 0) {
            break;
          }
          paramg = ((xv)localObject2).sVA.sWj;
          if (paramg != null) {
            a(locala, paramg.thumbUrl);
          }
          i = 1;
          break;
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((xv)localObject2).sVC + ":" + paramContext.getString(n.i.app_app) + "\n");
          }
          if (i != 0) {
            break;
          }
          paramg = ((xv)localObject2).sVA.sWl;
          if (paramg != null) {
            a(locala, paramg.thumbUrl);
          }
          i = 1;
          break;
          if (localLinkedList.size() < 4) {
            localLinkedList.add(((xv)localObject2).sVC + ":" + paramContext.getString(n.i.app_friend_card) + "\n");
          }
          if (i != 0) {
            break;
          }
          locala.kdm = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HN(((xv)localObject2).desc).pyp;
          i = 1;
          break;
          if (localLinkedList.size() >= 4) {
            break;
          }
          localLinkedList.add(((xv)localObject2).sVC + ":" + paramContext.getString(n.i.app_record) + "\n");
          break;
          if (localLinkedList.size() >= 4) {
            break;
          }
          if ((((xv)localObject2).sVA.sWu != null) && (((xv)localObject2).sVA.sWu.type == 3))
          {
            localLinkedList.add(((xv)localObject2).sVC + ":" + paramContext.getString(n.i.app_not_show) + "\n");
            break;
          }
          localLinkedList.add(((xv)localObject2).sVC + ":" + paramContext.getString(n.i.app_app_brand) + ((xv)localObject2).title + "\n");
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
          return locala;
        }
      }
    }
  }
  
  private static void a(a parama, String paramString)
  {
    paramString = com.tencent.mm.plugin.fav.a.b.aPI() + com.tencent.mm.a.g.o(bk.aM(paramString, "").getBytes());
    if (CY(paramString)) {
      parama.thumbPath = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.i.a
 * JD-Core Version:    0.7.0.1
 */
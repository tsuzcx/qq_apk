package com.tencent.mm.plugin.editor.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.editor.model.a.c;
import com.tencent.mm.plugin.editor.model.a.d;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.fav.a.aq;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public abstract class a
{
  public static String xxE = "";
  public static HashMap<String, JSONArray> xxF = new HashMap();
  public static String xxG = aq.dQY() + "/fav_fileicon_recording.png";
  private static String xxH = aq.dQY() + "/ofm_file_icon.png";
  private static String xxI = aq.dQY() + "/app_attach_file_icon_pic.png";
  public static String xxJ = aq.dQY() + "/location_msg.png";
  public static String xxK = aq.dQY() + "/note_fav_not_support.png";
  
  public static arv a(String paramString, List<d> paramList, arf paramarf)
  {
    LinkedList localLinkedList = new LinkedList();
    arv localarv = new arv();
    if (paramarf != null) {
      localLinkedList.add(paramarf);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label689;
        }
        paramarf = (d)paramString.next();
        if (paramarf != null)
        {
          if (paramarf.xyn == null) {
            break;
          }
          localLinkedList.add(paramarf.xyn);
        }
      }
      if ((!Util.isNullOrNil(paramString)) && (paramString.length() > 0))
      {
        paramString = aq.dRb();
        paramarf = new arf();
        paramarf.axy(8);
        paramarf.bsL("WeNoteHtmlFile");
        paramarf.Kk(true);
        paramarf.yo(y.bEl(paramString));
        paramarf.bsy(".htm");
        localLinkedList.add(paramarf);
        localObject1 = b.b(paramarf);
        if (!y.ZC((String)localObject1)) {
          y.O(paramString, (String)localObject1, false);
        }
        paramarf.bsC((String)localObject1);
      }
    }
    Object localObject1 = new arf();
    Object localObject2 = new arg();
    Object localObject3 = new arh();
    ((arh)localObject3).axC(6);
    ((arg)localObject2).c((arh)localObject3);
    ((arf)localObject1).a((arg)localObject2);
    switch (paramarf.type)
    {
    }
    for (;;)
    {
      ((arf)localObject1).bsL(paramarf.xyo);
      localLinkedList.add(localObject1);
      break;
      ((arf)localObject1).axy(2);
      localObject2 = (c)paramarf;
      localObject3 = ((c)localObject2).xym;
      ((arf)localObject1).bsC((String)localObject3);
      if (!Util.isNullOrNil(((c)paramarf).hIQ))
      {
        ((arf)localObject1).bsB(paramarf.hIQ);
        ((arf)localObject1).bsD(((c)localObject2).hTM);
      }
      for (;;)
      {
        ((arf)localObject1).axy(2);
        break;
        ((arf)localObject1).bsB(b.anz(localObject2.toString()));
        BitmapUtil.createThumbNail((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, b.a((arf)localObject1), true);
        ((arf)localObject1).bsD(b.a((arf)localObject1));
      }
      ((arf)localObject1).axy(3);
      localObject2 = (com.tencent.mm.plugin.editor.model.a.f)paramarf;
      ((arf)localObject1).bsB(paramarf.hIQ);
      localObject3 = ((com.tencent.mm.plugin.editor.model.a.f)localObject2).hTM;
      if ((Util.isNullOrNil((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((arf)localObject1).bsC((String)localObject3);
      ((arf)localObject1).axx(((com.tencent.mm.plugin.editor.model.a.f)localObject2).hIZ);
      ((arf)localObject1).Kk(true);
      ((arf)localObject1).bsy(((com.tencent.mm.plugin.editor.model.a.f)localObject2).xyq);
      continue;
      ((arf)localObject1).axy(4);
      localObject2 = (l)paramarf;
      ((arf)localObject1).bsB(paramarf.hIQ);
      ((arf)localObject1).bsC(((l)localObject2).hTM);
      ((arf)localObject1).bsD(((l)localObject2).thumbPath);
      localObject3 = com.tencent.mm.plugin.sight.base.f.aVX(((l)localObject2).hTM);
      if (localObject3 != null) {
        ((arf)localObject1).axx(((com.tencent.mm.plugin.sight.base.b)localObject3).getVideoDuration());
      }
      for (;;)
      {
        ((arf)localObject1).bsy(((l)localObject2).xyq);
        break;
        ((arf)localObject1).axx(1);
      }
      ((arf)localObject1).axy(1);
      ((arf)localObject1).Kj(true);
      ((arf)localObject1).Kk(true);
      localObject2 = (j)paramarf;
      ((arf)localObject1).bsB(paramarf.hIQ);
      ((arf)localObject1).bsp(com.tencent.mm.plugin.editor.b.anw(((j)localObject2).content));
      if ((!Util.isNullOrNil(((arf)localObject1).desc)) && (((arf)localObject1).desc.length() > 1000)) {
        ((arf)localObject1).bsp(((arf)localObject1).desc.substring(0, 1000));
      }
    }
    label689:
    a(localLinkedList, paramList);
    localarv.cs(localLinkedList);
    return localarv;
  }
  
  private static void a(LinkedList<arf> paramLinkedList, List<d> paramList)
  {
    Log.i("MicroMsg.EditorBase", "do EditorBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        arf localarf = (arf)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (Util.isNullOrNil(localarf.Ysw)))
        {
          localarf.bsB(b.anz(localarf.toString()));
          str1 = null;
          localObject = str1;
          if (i - 1 >= 0)
          {
            localObject = str1;
            if (i - 1 < paramList.size())
            {
              localObject = str1;
              if (paramList.size() > 0) {
                localObject = (d)paramList.get(i - 1);
              }
            }
          }
          if ((localObject != null) && (((d)localObject).xyo != null) && (((d)localObject).xyo.equals(localarf.ZzG))) {
            ((d)localObject).hIQ = localarf.hIQ;
          }
        }
        if ((i > 0) && (!Util.isNullOrNil(localarf.Ysw)) && (!Util.isNullOrNil(localarf.ZyH)))
        {
          localarf.Kj(true);
          localarf.Kk(true);
        }
        for (;;)
        {
          i += 1;
          break;
          Log.i("MicroMsg.EditorBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localarf.dataType) });
          localObject = localarf.Zzd;
          String str2;
          if (y.ZC((String)localObject))
          {
            Log.i("MicroMsg.EditorBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = y.bub((String)localObject);
            str2 = g.getMessageDigest(y.bi((String)localObject, 0, 256));
            localarf.bsz(str1);
            localarf.bsA(str2);
            localarf.yo(new u((String)localObject).length());
            str1 = b.b(localarf);
            boolean bool = y.ZC(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localarf.ZzG))) {
              y.O((String)localObject, str1, false);
            }
          }
          for (;;)
          {
            localObject = localarf.Zzf;
            if (!y.ZC((String)localObject)) {
              break label518;
            }
            Log.i("MicroMsg.EditorBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = y.bub((String)localObject);
            str2 = g.hu((String)localObject);
            localarf.bsE(str1);
            localarf.bsF(str2);
            localarf.yp(new u((String)localObject).length());
            str1 = b.a(localarf);
            if ((((String)localObject).equals(str1)) || (y.ZC(str1))) {
              break;
            }
            y.O((String)localObject, str1, false);
            break;
            Log.e("MicroMsg.EditorBase", "datapath not exist, %s not exist!", new Object[] { localObject });
          }
          label518:
          Log.e("MicroMsg.EditorBase", "thumbPath not exist, pathname:%s", new Object[] { localObject });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.a
 * JD-Core Version:    0.7.0.1
 */
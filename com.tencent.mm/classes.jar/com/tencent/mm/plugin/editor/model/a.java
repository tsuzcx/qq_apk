package com.tencent.mm.plugin.editor.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.plugin.editor.model.a.c;
import com.tencent.mm.plugin.editor.model.a.d;
import com.tencent.mm.plugin.editor.model.a.f;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public abstract class a
{
  public static String ptg = "";
  public static HashMap<String, JSONArray> pth = new HashMap();
  public static String pti = ao.cvB() + "/fav_fileicon_recording.png";
  private static String ptj = ao.cvB() + "/ofm_file_icon.png";
  private static String ptk = ao.cvB() + "/app_attach_file_icon_pic.png";
  public static String ptl = ao.cvB() + "/location_msg.png";
  public static String ptm = ao.cvB() + "/note_fav_not_support.png";
  
  public static akd a(String paramString, List<d> paramList, ajn paramajn)
  {
    LinkedList localLinkedList = new LinkedList();
    akd localakd = new akd();
    if (paramajn != null) {
      localLinkedList.add(paramajn);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label688;
        }
        paramajn = (d)paramString.next();
        if (paramajn != null)
        {
          if (paramajn.ptR == null) {
            break;
          }
          localLinkedList.add(paramajn.ptR);
        }
      }
      if ((!bt.isNullOrNil(paramString)) && (paramString.length() > 0))
      {
        paramString = ao.cvE();
        paramajn = new ajn();
        paramajn.ZI(8);
        paramajn.aOC("WeNoteHtmlFile");
        paramajn.wl(true);
        paramajn.CG(i.aYo(paramString));
        paramajn.aOp(".htm");
        localLinkedList.add(paramajn);
        localObject1 = b.b(paramajn);
        if (!i.fv((String)localObject1)) {
          i.mz(paramString, (String)localObject1);
        }
        paramajn.aOt((String)localObject1);
      }
    }
    Object localObject1 = new ajn();
    Object localObject2 = new ajo();
    Object localObject3 = new ajp();
    ((ajp)localObject3).ZM(6);
    ((ajo)localObject2).c((ajp)localObject3);
    ((ajn)localObject1).a((ajo)localObject2);
    switch (paramajn.type)
    {
    }
    for (;;)
    {
      ((ajn)localObject1).aOC(paramajn.ptS);
      localLinkedList.add(localObject1);
      break;
      ((ajn)localObject1).ZI(2);
      localObject2 = (c)paramajn;
      localObject3 = ((c)localObject2).ptQ;
      ((ajn)localObject1).aOt((String)localObject3);
      if (!bt.isNullOrNil(((c)paramajn).dsU))
      {
        ((ajn)localObject1).aOs(paramajn.dsU);
        ((ajn)localObject1).aOu(((c)localObject2).dBx);
      }
      for (;;)
      {
        ((ajn)localObject1).ZI(2);
        break;
        ((ajn)localObject1).aOs(b.aaU(localObject2.toString()));
        com.tencent.mm.sdk.platformtools.g.c((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, b.a((ajn)localObject1));
        ((ajn)localObject1).aOu(b.a((ajn)localObject1));
      }
      ((ajn)localObject1).ZI(3);
      localObject2 = (f)paramajn;
      ((ajn)localObject1).aOs(paramajn.dsU);
      localObject3 = ((f)localObject2).dBx;
      if ((bt.isNullOrNil((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((ajn)localObject1).aOt((String)localObject3);
      ((ajn)localObject1).ZH(((f)localObject2).dtd);
      ((ajn)localObject1).wl(true);
      ((ajn)localObject1).aOp(((f)localObject2).ptU);
      continue;
      ((ajn)localObject1).ZI(4);
      localObject2 = (l)paramajn;
      ((ajn)localObject1).aOs(paramajn.dsU);
      ((ajn)localObject1).aOt(((l)localObject2).dBx);
      ((ajn)localObject1).aOu(((l)localObject2).thumbPath);
      localObject3 = com.tencent.mm.plugin.sight.base.e.axx(((l)localObject2).dBx);
      if (localObject3 != null) {
        ((ajn)localObject1).ZH(((com.tencent.mm.plugin.sight.base.a)localObject3).getVideoDuration());
      }
      for (;;)
      {
        ((ajn)localObject1).aOp(((l)localObject2).ptU);
        break;
        ((ajn)localObject1).ZH(1);
      }
      ((ajn)localObject1).ZI(1);
      ((ajn)localObject1).wk(true);
      ((ajn)localObject1).wl(true);
      localObject2 = (j)paramajn;
      ((ajn)localObject1).aOs(paramajn.dsU);
      ((ajn)localObject1).aOg(com.tencent.mm.plugin.editor.b.aaR(((j)localObject2).content));
      if ((!bt.isNullOrNil(((ajn)localObject1).desc)) && (((ajn)localObject1).desc.length() > 1000)) {
        ((ajn)localObject1).aOg(((ajn)localObject1).desc.substring(0, 1000));
      }
    }
    label688:
    a(localLinkedList, paramList);
    localakd.bl(localLinkedList);
    return localakd;
  }
  
  private static void a(LinkedList<ajn> paramLinkedList, List<d> paramList)
  {
    ad.i("MicroMsg.EditorBase", "do EditorBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        ajn localajn = (ajn)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (bt.isNullOrNil(localajn.GgR)))
        {
          localajn.aOs(b.aaU(localajn.toString()));
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
          if ((localObject != null) && (((d)localObject).ptS != null) && (((d)localObject).ptS.equals(localajn.GhT))) {
            ((d)localObject).dsU = localajn.dsU;
          }
        }
        if ((i > 0) && (!bt.isNullOrNil(localajn.GgR)) && (!bt.isNullOrNil(localajn.GgT)))
        {
          localajn.wk(true);
          localajn.wl(true);
        }
        for (;;)
        {
          i += 1;
          break;
          ad.i("MicroMsg.EditorBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localajn.dataType) });
          localObject = localajn.Ghp;
          String str2;
          if (i.fv((String)localObject))
          {
            ad.i("MicroMsg.EditorBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = i.aPK((String)localObject);
            str2 = com.tencent.mm.b.g.getMessageDigest(i.aY((String)localObject, 0, 256));
            localajn.aOq(str1);
            localajn.aOr(str2);
            localajn.CG(new com.tencent.mm.vfs.e((String)localObject).length());
            str1 = b.b(localajn);
            boolean bool = i.fv(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localajn.GhT))) {
              i.mz((String)localObject, str1);
            }
          }
          for (;;)
          {
            localObject = localajn.Ghr;
            if (!i.fv((String)localObject)) {
              break label516;
            }
            ad.i("MicroMsg.EditorBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = i.aPK((String)localObject);
            str2 = com.tencent.mm.b.g.ep((String)localObject);
            localajn.aOv(str1);
            localajn.aOw(str2);
            localajn.CH(new com.tencent.mm.vfs.e((String)localObject).length());
            str1 = b.a(localajn);
            if ((((String)localObject).equals(str1)) || (i.fv(str1))) {
              break;
            }
            i.mz((String)localObject, str1);
            break;
            ad.e("MicroMsg.EditorBase", "datapath not exist, %s not exist!", new Object[] { localObject });
          }
          label516:
          ad.e("MicroMsg.EditorBase", "thumbPath not exist, pathname:%s", new Object[] { localObject });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.a
 * JD-Core Version:    0.7.0.1
 */
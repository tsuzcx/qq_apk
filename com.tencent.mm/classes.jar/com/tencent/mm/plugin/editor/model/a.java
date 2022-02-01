package com.tencent.mm.plugin.editor.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.editor.model.a.c;
import com.tencent.mm.plugin.editor.model.a.d;
import com.tencent.mm.plugin.editor.model.a.f;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public abstract class a
{
  public static String pzM = "";
  public static HashMap<String, JSONArray> pzN = new HashMap();
  public static String pzO = ao.cxc() + "/fav_fileicon_recording.png";
  private static String pzP = ao.cxc() + "/ofm_file_icon.png";
  private static String pzQ = ao.cxc() + "/app_attach_file_icon_pic.png";
  public static String pzR = ao.cxc() + "/location_msg.png";
  public static String pzS = ao.cxc() + "/note_fav_not_support.png";
  
  public static akn a(String paramString, List<d> paramList, ajx paramajx)
  {
    LinkedList localLinkedList = new LinkedList();
    akn localakn = new akn();
    if (paramajx != null) {
      localLinkedList.add(paramajx);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label688;
        }
        paramajx = (d)paramString.next();
        if (paramajx != null)
        {
          if (paramajx.pAv == null) {
            break;
          }
          localLinkedList.add(paramajx.pAv);
        }
      }
      if ((!bu.isNullOrNil(paramString)) && (paramString.length() > 0))
      {
        paramString = ao.cxf();
        paramajx = new ajx();
        paramajx.aao(8);
        paramajx.aPZ("WeNoteHtmlFile");
        paramajx.wt(true);
        paramajx.De(o.aZR(paramString));
        paramajx.aPM(".htm");
        localLinkedList.add(paramajx);
        localObject1 = b.b(paramajx);
        if (!o.fB((String)localObject1)) {
          o.mF(paramString, (String)localObject1);
        }
        paramajx.aPQ((String)localObject1);
      }
    }
    Object localObject1 = new ajx();
    Object localObject2 = new ajy();
    Object localObject3 = new ajz();
    ((ajz)localObject3).aas(6);
    ((ajy)localObject2).c((ajz)localObject3);
    ((ajx)localObject1).a((ajy)localObject2);
    switch (paramajx.type)
    {
    }
    for (;;)
    {
      ((ajx)localObject1).aPZ(paramajx.pAw);
      localLinkedList.add(localObject1);
      break;
      ((ajx)localObject1).aao(2);
      localObject2 = (c)paramajx;
      localObject3 = ((c)localObject2).pAu;
      ((ajx)localObject1).aPQ((String)localObject3);
      if (!bu.isNullOrNil(((c)paramajx).dua))
      {
        ((ajx)localObject1).aPP(paramajx.dua);
        ((ajx)localObject1).aPR(((c)localObject2).dCC);
      }
      for (;;)
      {
        ((ajx)localObject1).aao(2);
        break;
        ((ajx)localObject1).aPP(b.abL(localObject2.toString()));
        h.c((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, b.a((ajx)localObject1));
        ((ajx)localObject1).aPR(b.a((ajx)localObject1));
      }
      ((ajx)localObject1).aao(3);
      localObject2 = (f)paramajx;
      ((ajx)localObject1).aPP(paramajx.dua);
      localObject3 = ((f)localObject2).dCC;
      if ((bu.isNullOrNil((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((ajx)localObject1).aPQ((String)localObject3);
      ((ajx)localObject1).aan(((f)localObject2).duj);
      ((ajx)localObject1).wt(true);
      ((ajx)localObject1).aPM(((f)localObject2).pAy);
      continue;
      ((ajx)localObject1).aao(4);
      localObject2 = (l)paramajx;
      ((ajx)localObject1).aPP(paramajx.dua);
      ((ajx)localObject1).aPQ(((l)localObject2).dCC);
      ((ajx)localObject1).aPR(((l)localObject2).thumbPath);
      localObject3 = e.ayN(((l)localObject2).dCC);
      if (localObject3 != null) {
        ((ajx)localObject1).aan(((com.tencent.mm.plugin.sight.base.a)localObject3).getVideoDuration());
      }
      for (;;)
      {
        ((ajx)localObject1).aPM(((l)localObject2).pAy);
        break;
        ((ajx)localObject1).aan(1);
      }
      ((ajx)localObject1).aao(1);
      ((ajx)localObject1).ws(true);
      ((ajx)localObject1).wt(true);
      localObject2 = (j)paramajx;
      ((ajx)localObject1).aPP(paramajx.dua);
      ((ajx)localObject1).aPD(com.tencent.mm.plugin.editor.b.abI(((j)localObject2).content));
      if ((!bu.isNullOrNil(((ajx)localObject1).desc)) && (((ajx)localObject1).desc.length() > 1000)) {
        ((ajx)localObject1).aPD(((ajx)localObject1).desc.substring(0, 1000));
      }
    }
    label688:
    a(localLinkedList, paramList);
    localakn.bm(localLinkedList);
    return localakn;
  }
  
  private static void a(LinkedList<ajx> paramLinkedList, List<d> paramList)
  {
    ae.i("MicroMsg.EditorBase", "do EditorBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        ajx localajx = (ajx)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (bu.isNullOrNil(localajx.GzA)))
        {
          localajx.aPP(b.abL(localajx.toString()));
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
          if ((localObject != null) && (((d)localObject).pAw != null) && (((d)localObject).pAw.equals(localajx.GAC))) {
            ((d)localObject).dua = localajx.dua;
          }
        }
        if ((i > 0) && (!bu.isNullOrNil(localajx.GzA)) && (!bu.isNullOrNil(localajx.GzC)))
        {
          localajx.ws(true);
          localajx.wt(true);
        }
        for (;;)
        {
          i += 1;
          break;
          ae.i("MicroMsg.EditorBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localajx.dataType) });
          localObject = localajx.GzY;
          String str2;
          if (o.fB((String)localObject))
          {
            ae.i("MicroMsg.EditorBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = o.aRh((String)localObject);
            str2 = g.getMessageDigest(o.bb((String)localObject, 0, 256));
            localajx.aPN(str1);
            localajx.aPO(str2);
            localajx.De(new k((String)localObject).length());
            str1 = b.b(localajx);
            boolean bool = o.fB(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localajx.GAC))) {
              o.mF((String)localObject, str1);
            }
          }
          for (;;)
          {
            localObject = localajx.GAa;
            if (!o.fB((String)localObject)) {
              break label516;
            }
            ae.i("MicroMsg.EditorBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = o.aRh((String)localObject);
            str2 = g.eu((String)localObject);
            localajx.aPS(str1);
            localajx.aPT(str2);
            localajx.Df(new k((String)localObject).length());
            str1 = b.a(localajx);
            if ((((String)localObject).equals(str1)) || (o.fB(str1))) {
              break;
            }
            o.mF((String)localObject, str1);
            break;
            ae.e("MicroMsg.EditorBase", "datapath not exist, %s not exist!", new Object[] { localObject });
          }
          label516:
          ae.e("MicroMsg.EditorBase", "thumbPath not exist, pathname:%s", new Object[] { localObject });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.a
 * JD-Core Version:    0.7.0.1
 */
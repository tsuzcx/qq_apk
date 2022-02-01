package com.tencent.mm.plugin.editor.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.editor.model.a.c;
import com.tencent.mm.plugin.editor.model.a.d;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.ago;
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
  public static String olY = "";
  public static HashMap<String, JSONArray> olZ = new HashMap();
  public static String oma = ao.cip() + "/fav_fileicon_recording.png";
  private static String omb = ao.cip() + "/ofm_file_icon.png";
  private static String omc = ao.cip() + "/app_attach_file_icon_pic.png";
  public static String omd = ao.cip() + "/location_msg.png";
  public static String ome = ao.cip() + "/note_fav_not_support.png";
  
  public static ago a(String paramString, List<d> paramList, afy paramafy)
  {
    LinkedList localLinkedList = new LinkedList();
    ago localago = new ago();
    if (paramafy != null) {
      localLinkedList.add(paramafy);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label688;
        }
        paramafy = (d)paramString.next();
        if (paramafy != null)
        {
          if (paramafy.omH == null) {
            break;
          }
          localLinkedList.add(paramafy.omH);
        }
      }
      if ((!bt.isNullOrNil(paramString)) && (paramString.length() > 0))
      {
        paramString = ao.cis();
        paramafy = new afy();
        paramafy.VD(8);
        paramafy.aDI("WeNoteHtmlFile");
        paramafy.ux(true);
        paramafy.vp(i.aMN(paramString));
        paramafy.aDv(".htm");
        localLinkedList.add(paramafy);
        localObject1 = b.b(paramafy);
        if (!i.eK((String)localObject1)) {
          i.lC(paramString, (String)localObject1);
        }
        paramafy.aDz((String)localObject1);
      }
    }
    Object localObject1 = new afy();
    Object localObject2 = new afz();
    Object localObject3 = new aga();
    ((aga)localObject3).VH(6);
    ((afz)localObject2).c((aga)localObject3);
    ((afy)localObject1).a((afz)localObject2);
    switch (paramafy.type)
    {
    }
    for (;;)
    {
      ((afy)localObject1).aDI(paramafy.omI);
      localLinkedList.add(localObject1);
      break;
      ((afy)localObject1).VD(2);
      localObject2 = (c)paramafy;
      localObject3 = ((c)localObject2).omG;
      ((afy)localObject1).aDz((String)localObject3);
      if (!bt.isNullOrNil(((c)paramafy).dkb))
      {
        ((afy)localObject1).aDy(paramafy.dkb);
        ((afy)localObject1).aDA(((c)localObject2).drZ);
      }
      for (;;)
      {
        ((afy)localObject1).VD(2);
        break;
        ((afy)localObject1).aDy(b.Tb(localObject2.toString()));
        com.tencent.mm.sdk.platformtools.f.c((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, b.a((afy)localObject1));
        ((afy)localObject1).aDA(b.a((afy)localObject1));
      }
      ((afy)localObject1).VD(3);
      localObject2 = (com.tencent.mm.plugin.editor.model.a.f)paramafy;
      ((afy)localObject1).aDy(paramafy.dkb);
      localObject3 = ((com.tencent.mm.plugin.editor.model.a.f)localObject2).drZ;
      if ((bt.isNullOrNil((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((afy)localObject1).aDz((String)localObject3);
      ((afy)localObject1).VC(((com.tencent.mm.plugin.editor.model.a.f)localObject2).dkk);
      ((afy)localObject1).ux(true);
      ((afy)localObject1).aDv(((com.tencent.mm.plugin.editor.model.a.f)localObject2).omK);
      continue;
      ((afy)localObject1).VD(4);
      localObject2 = (l)paramafy;
      ((afy)localObject1).aDy(paramafy.dkb);
      ((afy)localObject1).aDz(((l)localObject2).drZ);
      ((afy)localObject1).aDA(((l)localObject2).thumbPath);
      localObject3 = com.tencent.mm.plugin.sight.base.e.ano(((l)localObject2).drZ);
      if (localObject3 != null) {
        ((afy)localObject1).VC(((com.tencent.mm.plugin.sight.base.a)localObject3).getVideoDuration());
      }
      for (;;)
      {
        ((afy)localObject1).aDv(((l)localObject2).omK);
        break;
        ((afy)localObject1).VC(1);
      }
      ((afy)localObject1).VD(1);
      ((afy)localObject1).uw(true);
      ((afy)localObject1).ux(true);
      localObject2 = (j)paramafy;
      ((afy)localObject1).aDy(paramafy.dkb);
      ((afy)localObject1).aDm(com.tencent.mm.plugin.editor.b.SY(((j)localObject2).content));
      if ((!bt.isNullOrNil(((afy)localObject1).desc)) && (((afy)localObject1).desc.length() > 1000)) {
        ((afy)localObject1).aDm(((afy)localObject1).desc.substring(0, 1000));
      }
    }
    label688:
    a(localLinkedList, paramList);
    localago.bd(localLinkedList);
    return localago;
  }
  
  private static void a(LinkedList<afy> paramLinkedList, List<d> paramList)
  {
    ad.i("MicroMsg.EditorBase", "do EditorBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        afy localafy = (afy)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (bt.isNullOrNil(localafy.DfZ)))
        {
          localafy.aDy(b.Tb(localafy.toString()));
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
          if ((localObject != null) && (((d)localObject).omI != null) && (((d)localObject).omI.equals(localafy.Dhb))) {
            ((d)localObject).dkb = localafy.dkb;
          }
        }
        if ((i > 0) && (!bt.isNullOrNil(localafy.DfZ)) && (!bt.isNullOrNil(localafy.Dgb)))
        {
          localafy.uw(true);
          localafy.ux(true);
        }
        for (;;)
        {
          i += 1;
          break;
          ad.i("MicroMsg.EditorBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localafy.dataType) });
          localObject = localafy.Dgx;
          String str2;
          if (i.eK((String)localObject))
          {
            ad.i("MicroMsg.EditorBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = i.aEN((String)localObject);
            str2 = g.getMessageDigest(i.aR((String)localObject, 0, 256));
            localafy.aDw(str1);
            localafy.aDx(str2);
            localafy.vp(new com.tencent.mm.vfs.e((String)localObject).length());
            str1 = b.b(localafy);
            boolean bool = i.eK(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localafy.Dhb))) {
              i.lC((String)localObject, str1);
            }
          }
          for (;;)
          {
            localObject = localafy.Dgz;
            if (!i.eK((String)localObject)) {
              break label516;
            }
            ad.i("MicroMsg.EditorBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = i.aEN((String)localObject);
            str2 = g.dE((String)localObject);
            localafy.aDB(str1);
            localafy.aDC(str2);
            localafy.vq(new com.tencent.mm.vfs.e((String)localObject).length());
            str1 = b.a(localafy);
            if ((((String)localObject).equals(str1)) || (i.eK(str1))) {
              break;
            }
            i.lC((String)localObject, str1);
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
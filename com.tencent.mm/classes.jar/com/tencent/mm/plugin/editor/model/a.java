package com.tencent.mm.plugin.editor.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.editor.model.a.c;
import com.tencent.mm.plugin.editor.model.a.d;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public abstract class a
{
  public static String oPA = ao.cpW() + "/fav_fileicon_recording.png";
  private static String oPB = ao.cpW() + "/ofm_file_icon.png";
  private static String oPC = ao.cpW() + "/app_attach_file_icon_pic.png";
  public static String oPD = ao.cpW() + "/location_msg.png";
  public static String oPE = ao.cpW() + "/note_fav_not_support.png";
  public static String oPy = "";
  public static HashMap<String, JSONArray> oPz = new HashMap();
  
  public static ahn a(String paramString, List<d> paramList, agx paramagx)
  {
    LinkedList localLinkedList = new LinkedList();
    ahn localahn = new ahn();
    if (paramagx != null) {
      localLinkedList.add(paramagx);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label688;
        }
        paramagx = (d)paramString.next();
        if (paramagx != null)
        {
          if (paramagx.oQh == null) {
            break;
          }
          localLinkedList.add(paramagx.oQh);
        }
      }
      if ((!bs.isNullOrNil(paramString)) && (paramString.length() > 0))
      {
        paramString = ao.cpZ();
        paramagx = new agx();
        paramagx.XM(8);
        paramagx.aIZ("WeNoteHtmlFile");
        paramagx.vz(true);
        paramagx.zS(i.aSp(paramString));
        paramagx.aIM(".htm");
        localLinkedList.add(paramagx);
        localObject1 = b.b(paramagx);
        if (!i.eA((String)localObject1)) {
          i.lZ(paramString, (String)localObject1);
        }
        paramagx.aIQ((String)localObject1);
      }
    }
    Object localObject1 = new agx();
    Object localObject2 = new agy();
    Object localObject3 = new agz();
    ((agz)localObject3).XQ(6);
    ((agy)localObject2).c((agz)localObject3);
    ((agx)localObject1).a((agy)localObject2);
    switch (paramagx.type)
    {
    }
    for (;;)
    {
      ((agx)localObject1).aIZ(paramagx.oQi);
      localLinkedList.add(localObject1);
      break;
      ((agx)localObject1).XM(2);
      localObject2 = (c)paramagx;
      localObject3 = ((c)localObject2).oQg;
      ((agx)localObject1).aIQ((String)localObject3);
      if (!bs.isNullOrNil(((c)paramagx).dhw))
      {
        ((agx)localObject1).aIP(paramagx.dhw);
        ((agx)localObject1).aIR(((c)localObject2).dpK);
      }
      for (;;)
      {
        ((agx)localObject1).XM(2);
        break;
        ((agx)localObject1).aIP(b.Xn(localObject2.toString()));
        com.tencent.mm.sdk.platformtools.f.c((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, b.a((agx)localObject1));
        ((agx)localObject1).aIR(b.a((agx)localObject1));
      }
      ((agx)localObject1).XM(3);
      localObject2 = (com.tencent.mm.plugin.editor.model.a.f)paramagx;
      ((agx)localObject1).aIP(paramagx.dhw);
      localObject3 = ((com.tencent.mm.plugin.editor.model.a.f)localObject2).dpK;
      if ((bs.isNullOrNil((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((agx)localObject1).aIQ((String)localObject3);
      ((agx)localObject1).XL(((com.tencent.mm.plugin.editor.model.a.f)localObject2).dhF);
      ((agx)localObject1).vz(true);
      ((agx)localObject1).aIM(((com.tencent.mm.plugin.editor.model.a.f)localObject2).oQk);
      continue;
      ((agx)localObject1).XM(4);
      localObject2 = (l)paramagx;
      ((agx)localObject1).aIP(paramagx.dhw);
      ((agx)localObject1).aIQ(((l)localObject2).dpK);
      ((agx)localObject1).aIR(((l)localObject2).thumbPath);
      localObject3 = com.tencent.mm.plugin.sight.base.e.asx(((l)localObject2).dpK);
      if (localObject3 != null) {
        ((agx)localObject1).XL(((com.tencent.mm.plugin.sight.base.a)localObject3).getVideoDuration());
      }
      for (;;)
      {
        ((agx)localObject1).aIM(((l)localObject2).oQk);
        break;
        ((agx)localObject1).XL(1);
      }
      ((agx)localObject1).XM(1);
      ((agx)localObject1).vy(true);
      ((agx)localObject1).vz(true);
      localObject2 = (j)paramagx;
      ((agx)localObject1).aIP(paramagx.dhw);
      ((agx)localObject1).aID(com.tencent.mm.plugin.editor.b.Xk(((j)localObject2).content));
      if ((!bs.isNullOrNil(((agx)localObject1).desc)) && (((agx)localObject1).desc.length() > 1000)) {
        ((agx)localObject1).aID(((agx)localObject1).desc.substring(0, 1000));
      }
    }
    label688:
    a(localLinkedList, paramList);
    localahn.bk(localLinkedList);
    return localahn;
  }
  
  private static void a(LinkedList<agx> paramLinkedList, List<d> paramList)
  {
    ac.i("MicroMsg.EditorBase", "do EditorBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        agx localagx = (agx)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (bs.isNullOrNil(localagx.Ezf)))
        {
          localagx.aIP(b.Xn(localagx.toString()));
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
          if ((localObject != null) && (((d)localObject).oQi != null) && (((d)localObject).oQi.equals(localagx.EAh))) {
            ((d)localObject).dhw = localagx.dhw;
          }
        }
        if ((i > 0) && (!bs.isNullOrNil(localagx.Ezf)) && (!bs.isNullOrNil(localagx.Ezh)))
        {
          localagx.vy(true);
          localagx.vz(true);
        }
        for (;;)
        {
          i += 1;
          break;
          ac.i("MicroMsg.EditorBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localagx.dataType) });
          localObject = localagx.EzD;
          String str2;
          if (i.eA((String)localObject))
          {
            ac.i("MicroMsg.EditorBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = i.aKe((String)localObject);
            str2 = g.getMessageDigest(i.aU((String)localObject, 0, 256));
            localagx.aIN(str1);
            localagx.aIO(str2);
            localagx.zS(new com.tencent.mm.vfs.e((String)localObject).length());
            str1 = b.b(localagx);
            boolean bool = i.eA(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localagx.EAh))) {
              i.lZ((String)localObject, str1);
            }
          }
          for (;;)
          {
            localObject = localagx.EzF;
            if (!i.eA((String)localObject)) {
              break label516;
            }
            ac.i("MicroMsg.EditorBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = i.aKe((String)localObject);
            str2 = g.dt((String)localObject);
            localagx.aIS(str1);
            localagx.aIT(str2);
            localagx.zT(new com.tencent.mm.vfs.e((String)localObject).length());
            str1 = b.a(localagx);
            if ((((String)localObject).equals(str1)) || (i.eA(str1))) {
              break;
            }
            i.lZ((String)localObject, str1);
            break;
            ac.e("MicroMsg.EditorBase", "datapath not exist, %s not exist!", new Object[] { localObject });
          }
          label516:
          ac.e("MicroMsg.EditorBase", "thumbPath not exist, pathname:%s", new Object[] { localObject });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.a
 * JD-Core Version:    0.7.0.1
 */
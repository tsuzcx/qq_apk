package com.tencent.mm.plugin.editor.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.editor.model.a.c;
import com.tencent.mm.plugin.editor.model.a.d;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.fav.a.ap;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public abstract class a
{
  public static String urh = "";
  public static HashMap<String, JSONArray> urj = new HashMap();
  public static String urk = ap.dkm() + "/fav_fileicon_recording.png";
  private static String urm = ap.dkm() + "/ofm_file_icon.png";
  private static String urn = ap.dkm() + "/app_attach_file_icon_pic.png";
  public static String uro = ap.dkm() + "/location_msg.png";
  public static String urp = ap.dkm() + "/note_fav_not_support.png";
  
  public static aoc a(String paramString, List<d> paramList, anm paramanm)
  {
    LinkedList localLinkedList = new LinkedList();
    aoc localaoc = new aoc();
    if (paramanm != null) {
      localLinkedList.add(paramanm);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label689;
        }
        paramanm = (d)paramString.next();
        if (paramanm != null)
        {
          if (paramanm.urS == null) {
            break;
          }
          localLinkedList.add(paramanm.urS);
        }
      }
      if ((!Util.isNullOrNil(paramString)) && (paramString.length() > 0))
      {
        paramString = ap.dkp();
        paramanm = new anm();
        paramanm.arq(8);
        paramanm.bsU("WeNoteHtmlFile");
        paramanm.Ey(true);
        paramanm.TY(u.bBQ(paramString));
        paramanm.bsH(".htm");
        localLinkedList.add(paramanm);
        localObject1 = b.b(paramanm);
        if (!u.agG((String)localObject1)) {
          u.on(paramString, (String)localObject1);
        }
        paramanm.bsL((String)localObject1);
      }
    }
    Object localObject1 = new anm();
    Object localObject2 = new ann();
    Object localObject3 = new ano();
    ((ano)localObject3).aru(6);
    ((ann)localObject2).c((ano)localObject3);
    ((anm)localObject1).a((ann)localObject2);
    switch (paramanm.type)
    {
    }
    for (;;)
    {
      ((anm)localObject1).bsU(paramanm.urT);
      localLinkedList.add(localObject1);
      break;
      ((anm)localObject1).arq(2);
      localObject2 = (c)paramanm;
      localObject3 = ((c)localObject2).urR;
      ((anm)localObject1).bsL((String)localObject3);
      if (!Util.isNullOrNil(((c)paramanm).fEa))
      {
        ((anm)localObject1).bsK(paramanm.fEa);
        ((anm)localObject1).bsM(((c)localObject2).fNU);
      }
      for (;;)
      {
        ((anm)localObject1).arq(2);
        break;
        ((anm)localObject1).bsK(b.atK(localObject2.toString()));
        BitmapUtil.createThumbNail((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, b.a((anm)localObject1), true);
        ((anm)localObject1).bsM(b.a((anm)localObject1));
      }
      ((anm)localObject1).arq(3);
      localObject2 = (com.tencent.mm.plugin.editor.model.a.f)paramanm;
      ((anm)localObject1).bsK(paramanm.fEa);
      localObject3 = ((com.tencent.mm.plugin.editor.model.a.f)localObject2).fNU;
      if ((Util.isNullOrNil((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((anm)localObject1).bsL((String)localObject3);
      ((anm)localObject1).arp(((com.tencent.mm.plugin.editor.model.a.f)localObject2).fEj);
      ((anm)localObject1).Ey(true);
      ((anm)localObject1).bsH(((com.tencent.mm.plugin.editor.model.a.f)localObject2).urV);
      continue;
      ((anm)localObject1).arq(4);
      localObject2 = (l)paramanm;
      ((anm)localObject1).bsK(paramanm.fEa);
      ((anm)localObject1).bsL(((l)localObject2).fNU);
      ((anm)localObject1).bsM(((l)localObject2).thumbPath);
      localObject3 = com.tencent.mm.plugin.sight.base.f.aYg(((l)localObject2).fNU);
      if (localObject3 != null) {
        ((anm)localObject1).arp(((com.tencent.mm.plugin.sight.base.b)localObject3).getVideoDuration());
      }
      for (;;)
      {
        ((anm)localObject1).bsH(((l)localObject2).urV);
        break;
        ((anm)localObject1).arp(1);
      }
      ((anm)localObject1).arq(1);
      ((anm)localObject1).Ex(true);
      ((anm)localObject1).Ey(true);
      localObject2 = (j)paramanm;
      ((anm)localObject1).bsK(paramanm.fEa);
      ((anm)localObject1).bsy(com.tencent.mm.plugin.editor.b.atH(((j)localObject2).content));
      if ((!Util.isNullOrNil(((anm)localObject1).desc)) && (((anm)localObject1).desc.length() > 1000)) {
        ((anm)localObject1).bsy(((anm)localObject1).desc.substring(0, 1000));
      }
    }
    label689:
    a(localLinkedList, paramList);
    localaoc.cg(localLinkedList);
    return localaoc;
  }
  
  private static void a(LinkedList<anm> paramLinkedList, List<d> paramList)
  {
    Log.i("MicroMsg.EditorBase", "do EditorBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        anm localanm = (anm)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (Util.isNullOrNil(localanm.Rwb)))
        {
          localanm.bsK(b.atK(localanm.toString()));
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
          if ((localObject != null) && (((d)localObject).urT != null) && (((d)localObject).urT.equals(localanm.SyO))) {
            ((d)localObject).fEa = localanm.fEa;
          }
        }
        if ((i > 0) && (!Util.isNullOrNil(localanm.Rwb)) && (!Util.isNullOrNil(localanm.SxP)))
        {
          localanm.Ex(true);
          localanm.Ey(true);
        }
        for (;;)
        {
          i += 1;
          break;
          Log.i("MicroMsg.EditorBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localanm.dataType) });
          localObject = localanm.Syl;
          String str2;
          if (u.agG((String)localObject))
          {
            Log.i("MicroMsg.EditorBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = u.buc((String)localObject);
            str2 = g.getMessageDigest(u.aY((String)localObject, 0, 256));
            localanm.bsI(str1);
            localanm.bsJ(str2);
            localanm.TY(new q((String)localObject).length());
            str1 = b.b(localanm);
            boolean bool = u.agG(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localanm.SyO))) {
              u.on((String)localObject, str1);
            }
          }
          for (;;)
          {
            localObject = localanm.Syn;
            if (!u.agG((String)localObject)) {
              break label516;
            }
            Log.i("MicroMsg.EditorBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = u.buc((String)localObject);
            str2 = g.fR((String)localObject);
            localanm.bsN(str1);
            localanm.bsO(str2);
            localanm.TZ(new q((String)localObject).length());
            str1 = b.a(localanm);
            if ((((String)localObject).equals(str1)) || (u.agG(str1))) {
              break;
            }
            u.on((String)localObject, str1);
            break;
            Log.e("MicroMsg.EditorBase", "datapath not exist, %s not exist!", new Object[] { localObject });
          }
          label516:
          Log.e("MicroMsg.EditorBase", "thumbPath not exist, pathname:%s", new Object[] { localObject });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.a
 * JD-Core Version:    0.7.0.1
 */
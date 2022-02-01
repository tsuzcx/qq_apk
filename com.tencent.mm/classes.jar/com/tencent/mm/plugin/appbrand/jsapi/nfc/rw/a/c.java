package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.d;
import com.tencent.mm.plugin.appbrand.utils.ae;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NdefMessageConverter;", "", "()V", "MAP_KEY_MESSAGES", "", "MAP_KEY_RECORDS", "NDEF_RECORD_FIELD_ID", "NDEF_RECORD_FIELD_PAYLOAD", "NDEF_RECORD_FIELD_TNF", "NDEF_RECORD_FIELD_TYPE", "PARAM_LANGUAGE", "PARAM_TEXT", "TAG", "map2Message", "Landroid/nfc/NdefMessage;", "messageMap", "", "message2MessageMap", "Lkotlin/Pair;", "", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/MessageMap;", "message", "messages2Map", "messages", "record2RecordMap", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/RecordMap;", "record", "Landroid/nfc/NdefRecord;", "recordMap2Record", "recordMap", "texts2Message", "textAndLanguages", "uris2Message", "uris", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c smP;
  
  static
  {
    AppMethodBeat.i(183705);
    smP = new c();
    AppMethodBeat.o(183705);
  }
  
  public static NdefMessage Q(Map<String, ? extends Object> paramMap)
  {
    int i = 0;
    AppMethodBeat.i(183700);
    s.u(paramMap, "messageMap");
    Log.d("MicroMsg.AppBrand.NdefMessageConverter", s.X("map2Message, messageMap: ", paramMap));
    Object localObject = paramMap.get("records");
    if ((localObject instanceof List)) {}
    for (localObject = (List)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(183700);
      return null;
    }
    localObject = (Iterable)localObject;
    Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      Map localMap = (Map)localObject;
      Log.d("MicroMsg.AppBrand.NdefMessageConverter", "map2Message, index: " + i + ", map: " + localMap);
      localObject = paramMap.get(s.X("payload-", Integer.valueOf(i)));
      if ((localObject instanceof ByteBuffer)) {}
      for (localObject = (ByteBuffer)localObject; localObject == null; localObject = null)
      {
        AppMethodBeat.o(183700);
        return null;
      }
      Log.d("MicroMsg.AppBrand.NdefMessageConverter", s.X("map2Message, byteBuffer: ", localObject));
      localCollection.add(a(v.Y(localMap, localObject)));
      i += 1;
    }
    paramMap = (List)localCollection;
    Log.d("MicroMsg.AppBrand.NdefMessageConverter", s.X("map2Message, records: ", paramMap));
    try
    {
      paramMap = ((Collection)paramMap).toArray(new NdefRecord[0]);
      if (paramMap == null)
      {
        paramMap = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(183700);
        throw paramMap;
      }
    }
    catch (Exception paramMap)
    {
      Log.w("MicroMsg.AppBrand.NdefMessageConverter", s.X("create NdefMessage failed since ", paramMap));
      paramMap = null;
    }
    for (;;)
    {
      AppMethodBeat.o(183700);
      return paramMap;
      paramMap = new NdefMessage((NdefRecord[])paramMap);
    }
  }
  
  private static NdefRecord a(r<? extends Map<String, ? extends Object>, ? extends ByteBuffer> paramr)
  {
    Object localObject2 = null;
    AppMethodBeat.i(183704);
    Log.d("MicroMsg.AppBrand.NdefMessageConverter", s.X("recordMap2Record, recordMap: ", paramr));
    Object localObject1 = (Map)paramr.bsC;
    ByteBuffer localByteBuffer = (ByteBuffer)paramr.bsD;
    paramr = ((Map)localObject1).get("tnf");
    if ((paramr instanceof Integer)) {}
    for (paramr = (Integer)paramr; paramr == null; paramr = null)
    {
      AppMethodBeat.o(183704);
      return null;
    }
    int i = paramr.intValue();
    paramr = ((Map)localObject1).get("type");
    if ((paramr instanceof String)) {
      paramr = (String)paramr;
    }
    for (;;)
    {
      if (paramr == null)
      {
        paramr = null;
        label104:
        localObject1 = ((Map)localObject1).get("id");
        if (!(localObject1 instanceof String)) {
          break label169;
        }
        localObject1 = (String)localObject1;
        label125:
        if (localObject1 != null) {
          break label174;
        }
        localObject1 = null;
      }
      try
      {
        for (;;)
        {
          paramr = new NdefRecord((short)i, paramr, (byte[])localObject1, d.s(localByteBuffer));
          AppMethodBeat.o(183704);
          return paramr;
          paramr = null;
          break;
          paramr = Base64.decode(paramr, 2);
          break label104;
          label169:
          localObject1 = null;
          break label125;
          label174:
          localObject1 = Base64.decode((String)localObject1, 2);
        }
      }
      catch (Exception paramr)
      {
        for (;;)
        {
          Log.w("MicroMsg.AppBrand.NdefMessageConverter", s.X("recordMap2Record failed since ", paramr));
          paramr = localObject2;
        }
      }
    }
  }
  
  private static r<List<Map<String, Object>>, List<ByteBuffer>> a(NdefMessage paramNdefMessage)
  {
    AppMethodBeat.i(183703);
    Log.d("MicroMsg.AppBrand.NdefMessageConverter", s.X("message2MessageMap, message: ", paramNdefMessage));
    paramNdefMessage = paramNdefMessage.getRecords();
    s.s(paramNdefMessage, "message.records");
    paramNdefMessage = (Object[])paramNdefMessage;
    Object localObject1 = (Collection)new ArrayList(paramNdefMessage.length);
    int j = paramNdefMessage.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = (NdefRecord)paramNdefMessage[i];
      s.s(localObject2, "it");
      Log.d("MicroMsg.AppBrand.NdefMessageConverter", s.X("record2RecordMap, record: ", localObject2));
      Object localObject3 = v.Y("tnf", Short.valueOf(((NdefRecord)localObject2).getTnf()));
      Object localObject4 = Base64.encode(((NdefRecord)localObject2).getType(), 2);
      s.s(localObject4, "encode(record.type, Base64.NO_WRAP)");
      Object localObject5 = StandardCharsets.UTF_8;
      s.s(localObject5, "UTF_8");
      localObject4 = v.Y("type", new String((byte[])localObject4, (Charset)localObject5));
      localObject5 = Base64.encode(((NdefRecord)localObject2).getId(), 2);
      s.s(localObject5, "encode(record.id, Base64.NO_WRAP)");
      Charset localCharset = StandardCharsets.UTF_8;
      s.s(localCharset, "UTF_8");
      localObject3 = ak.e(new r[] { localObject3, localObject4, v.Y("id", new String((byte[])localObject5, localCharset)) });
      Log.d("MicroMsg.AppBrand.NdefMessageConverter", s.X("record2RecordMap, map: ", localObject3));
      ((Collection)localObject1).add(v.Y(localObject3, ae.bc(((NdefRecord)localObject2).getPayload())));
      i += 1;
    }
    paramNdefMessage = (List)localObject1;
    Object localObject2 = (Iterable)paramNdefMessage;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add((Map)((r)((Iterator)localObject2).next()).bsC);
    }
    localObject1 = (List)localObject1;
    localObject2 = (Iterable)paramNdefMessage;
    paramNdefMessage = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramNdefMessage.add((ByteBuffer)((r)((Iterator)localObject2).next()).bsD);
    }
    paramNdefMessage = v.Y(localObject1, (List)paramNdefMessage);
    Log.d("MicroMsg.AppBrand.NdefMessageConverter", s.X("message2MessageMap, messageMap: ", paramNdefMessage));
    AppMethodBeat.o(183703);
    return paramNdefMessage;
  }
  
  public static Map<String, Object> jdMethod_do(List<NdefMessage> paramList)
  {
    AppMethodBeat.i(183699);
    s.u(paramList, "messages");
    Log.d("MicroMsg.AppBrand.NdefMessageConverter", s.X("messages2Map, messages: ", paramList));
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(a((NdefMessage)((Iterator)localObject1).next()));
    }
    localObject1 = (List)paramList;
    Object localObject2 = (Iterable)localObject1;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramList.add((List)((r)((Iterator)localObject2).next()).bsC);
    }
    paramList = ak.f(new r[] { v.Y("messages", (List)paramList) });
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = ((Iterable)((r)localObject2).bsD).iterator();
      int j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (j < 0) {
          p.kkW();
        }
        localObject3 = (ByteBuffer)localObject3;
        paramList.put("payload-" + i + '-' + j, localObject3);
        j += 1;
      }
      i += 1;
    }
    Log.d("MicroMsg.AppBrand.NdefMessageConverter", s.X("messages2Map, map: ", paramList));
    AppMethodBeat.o(183699);
    return paramList;
  }
  
  public static NdefMessage dp(List<String> paramList)
  {
    AppMethodBeat.i(183701);
    s.u(paramList, "uris");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      try
      {
        localObject2 = NdefRecord.createUri((String)localObject2);
        paramList.add(localObject2);
      }
      catch (Exception paramList)
      {
        Log.w("MicroMsg.AppBrand.NdefMessageConverter", s.X("createUri failed since ", paramList));
        AppMethodBeat.o(183701);
        return null;
      }
    }
    paramList = ((Collection)paramList).toArray(new NdefRecord[0]);
    if (paramList == null)
    {
      paramList = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(183701);
      throw paramList;
    }
    paramList = (NdefRecord[])paramList;
    try
    {
      paramList = new NdefMessage(paramList);
      AppMethodBeat.o(183701);
      return paramList;
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.NdefMessageConverter", s.X("create NdefMessage failed since ", paramList));
        paramList = null;
      }
    }
  }
  
  public static NdefMessage dq(List<? extends Map<String, String>> paramList)
  {
    AppMethodBeat.i(183702);
    s.u(paramList, "textAndLanguages");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map)((Iterator)localObject1).next();
      Object localObject2 = (String)((Map)localObject3).get("text");
      if (localObject2 == null)
      {
        AppMethodBeat.o(183702);
        return null;
      }
      localObject3 = (String)((Map)localObject3).get("language");
      if (localObject3 == null)
      {
        AppMethodBeat.o(183702);
        return null;
      }
      try
      {
        localObject2 = NdefRecord.createTextRecord((String)localObject3, (String)localObject2);
        paramList.add(localObject2);
      }
      catch (Exception paramList)
      {
        Log.w("MicroMsg.AppBrand.NdefMessageConverter", s.X("createTextRecord failed since ", paramList));
        AppMethodBeat.o(183702);
        return null;
      }
    }
    paramList = ((Collection)paramList).toArray(new NdefRecord[0]);
    if (paramList == null)
    {
      paramList = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(183702);
      throw paramList;
    }
    paramList = (NdefRecord[])paramList;
    try
    {
      paramList = new NdefMessage(paramList);
      AppMethodBeat.o(183702);
      return paramList;
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.NdefMessageConverter", s.X("create NdefMessage failed since ", paramList));
        paramList = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c
 * JD-Core Version:    0.7.0.1
 */
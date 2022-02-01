package com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.ae;
import d.a.j;
import d.g.b.k;
import d.l;
import d.o;
import d.o<+Ljava.util.Map<Ljava.lang.String;+Ljava.lang.Object;>;+Ljava.nio.ByteBuffer;>;
import d.u;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NdefMessageConverter;", "", "()V", "MAP_KEY_MESSAGES", "", "MAP_KEY_RECORDS", "NDEF_RECORD_FIELD_ID", "NDEF_RECORD_FIELD_PAYLOAD", "NDEF_RECORD_FIELD_TNF", "NDEF_RECORD_FIELD_TYPE", "PARAM_LANGUAGE", "PARAM_TEXT", "TAG", "map2Message", "Landroid/nfc/NdefMessage;", "messageMap", "", "message2MessageMap", "Lkotlin/Pair;", "", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/MessageMap;", "message", "messages2Map", "messages", "record2RecordMap", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/RecordMap;", "record", "Landroid/nfc/NdefRecord;", "recordMap2Record", "recordMap", "texts2Message", "textAndLanguages", "uris2Message", "uris", "luggage-commons-jsapi-nfc-ext_release"})
public final class c
{
  public static final c kdw;
  
  static
  {
    AppMethodBeat.i(183705);
    kdw = new c();
    AppMethodBeat.o(183705);
  }
  
  public static NdefMessage H(Map<String, ? extends Object> paramMap)
  {
    int i = 0;
    Object localObject2 = null;
    AppMethodBeat.i(183700);
    k.h(paramMap, "messageMap");
    ad.d("MicroMsg.AppBrand.NdefMessageConverter", "map2Message, messageMap: ".concat(String.valueOf(paramMap)));
    Object localObject3 = paramMap.get("records");
    Object localObject1 = localObject3;
    if (!(localObject3 instanceof List)) {
      localObject1 = null;
    }
    localObject1 = (List)localObject1;
    if (localObject1 == null)
    {
      AppMethodBeat.o(183700);
      return null;
    }
    localObject1 = (Iterable)localObject1;
    Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (i < 0) {
        j.fvx();
      }
      Map localMap = (Map)localObject1;
      ad.d("MicroMsg.AppBrand.NdefMessageConverter", "map2Message, index: " + i + ", map: " + localMap);
      localObject3 = paramMap.get("payload-".concat(String.valueOf(i)));
      localObject1 = localObject3;
      if (!(localObject3 instanceof ByteBuffer)) {
        localObject1 = null;
      }
      localObject1 = (ByteBuffer)localObject1;
      if (localObject1 == null)
      {
        AppMethodBeat.o(183700);
        return null;
      }
      ad.d("MicroMsg.AppBrand.NdefMessageConverter", "map2Message, byteBuffer: ".concat(String.valueOf(localObject1)));
      localCollection.add(a(u.P(localMap, localObject1)));
      i += 1;
    }
    paramMap = (List)localCollection;
    ad.d("MicroMsg.AppBrand.NdefMessageConverter", "map2Message, records: ".concat(String.valueOf(paramMap)));
    try
    {
      paramMap = ((Collection)paramMap).toArray(new NdefRecord[0]);
      if (paramMap == null)
      {
        paramMap = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(183700);
        throw paramMap;
      }
    }
    catch (Exception paramMap)
    {
      ad.w("MicroMsg.AppBrand.NdefMessageConverter", "create NdefMessage failed since ".concat(String.valueOf(paramMap)));
      paramMap = localObject2;
    }
    for (;;)
    {
      AppMethodBeat.o(183700);
      return paramMap;
      paramMap = new NdefMessage((NdefRecord[])paramMap);
    }
  }
  
  private static NdefRecord a(o<? extends Map<String, ? extends Object>, ? extends ByteBuffer> paramo)
  {
    Object localObject2 = null;
    AppMethodBeat.i(183704);
    ad.d("MicroMsg.AppBrand.NdefMessageConverter", "recordMap2Record, recordMap: ".concat(String.valueOf(paramo)));
    Object localObject3 = (Map)paramo.first;
    ByteBuffer localByteBuffer = (ByteBuffer)paramo.second;
    Object localObject1 = ((Map)localObject3).get("tnf");
    paramo = (o<? extends Map<String, ? extends Object>, ? extends ByteBuffer>)localObject1;
    if (!(localObject1 instanceof Integer)) {
      paramo = null;
    }
    paramo = (Integer)paramo;
    int i;
    if (paramo != null)
    {
      i = paramo.intValue();
      localObject1 = ((Map)localObject3).get("type");
      paramo = (o<? extends Map<String, ? extends Object>, ? extends ByteBuffer>)localObject1;
      if (!(localObject1 instanceof String)) {
        paramo = null;
      }
      paramo = (String)paramo;
      if (paramo == null) {
        break label180;
      }
      paramo = Base64.decode(paramo, 2);
    }
    for (;;)
    {
      localObject3 = ((Map)localObject3).get("id");
      localObject1 = localObject3;
      if (!(localObject3 instanceof String)) {
        localObject1 = null;
      }
      localObject1 = (String)localObject1;
      if (localObject1 != null) {
        localObject1 = Base64.decode((String)localObject1, 2);
      }
      try
      {
        for (;;)
        {
          paramo = new NdefRecord((short)i, paramo, (byte[])localObject1, d.q(localByteBuffer));
          AppMethodBeat.o(183704);
          return paramo;
          AppMethodBeat.o(183704);
          return null;
          label180:
          paramo = null;
          break;
          localObject1 = null;
        }
      }
      catch (Exception paramo)
      {
        for (;;)
        {
          ad.w("MicroMsg.AppBrand.NdefMessageConverter", "recordMap2Record failed since ".concat(String.valueOf(paramo)));
          paramo = localObject2;
        }
      }
    }
  }
  
  private static o<List<Map<String, Object>>, List<ByteBuffer>> a(NdefMessage paramNdefMessage)
  {
    AppMethodBeat.i(183703);
    ad.d("MicroMsg.AppBrand.NdefMessageConverter", "message2MessageMap, message: ".concat(String.valueOf(paramNdefMessage)));
    paramNdefMessage = paramNdefMessage.getRecords();
    k.g(paramNdefMessage, "message.records");
    Object localObject1 = (Collection)new ArrayList(paramNdefMessage.length);
    int j = paramNdefMessage.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = paramNdefMessage[i];
      k.g(localObject2, "it");
      ad.d("MicroMsg.AppBrand.NdefMessageConverter", "record2RecordMap, record: ".concat(String.valueOf(localObject2)));
      Object localObject3 = u.P("tnf", Short.valueOf(((NdefRecord)localObject2).getTnf()));
      Object localObject4 = Base64.encode(((NdefRecord)localObject2).getType(), 2);
      k.g(localObject4, "Base64.encode(record.type, Base64.NO_WRAP)");
      Object localObject5 = StandardCharsets.UTF_8;
      k.g(localObject5, "StandardCharsets.UTF_8");
      localObject4 = u.P("type", new String((byte[])localObject4, (Charset)localObject5));
      localObject5 = Base64.encode(((NdefRecord)localObject2).getId(), 2);
      k.g(localObject5, "Base64.encode(record.id, Base64.NO_WRAP)");
      Charset localCharset = StandardCharsets.UTF_8;
      k.g(localCharset, "StandardCharsets.UTF_8");
      localObject3 = ae.a(new o[] { localObject3, localObject4, u.P("id", new String((byte[])localObject5, localCharset)) });
      ad.d("MicroMsg.AppBrand.NdefMessageConverter", "record2RecordMap, map: ".concat(String.valueOf(localObject3)));
      ((Collection)localObject1).add(u.P(localObject3, com.tencent.mm.plugin.appbrand.utils.v.az(((NdefRecord)localObject2).getPayload())));
      i += 1;
    }
    paramNdefMessage = (List)localObject1;
    Object localObject2 = (Iterable)paramNdefMessage;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add((Map)((o)((Iterator)localObject2).next()).first);
    }
    localObject1 = (List)localObject1;
    localObject2 = (Iterable)paramNdefMessage;
    paramNdefMessage = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramNdefMessage.add((ByteBuffer)((o)((Iterator)localObject2).next()).second);
    }
    paramNdefMessage = u.P(localObject1, (List)paramNdefMessage);
    ad.d("MicroMsg.AppBrand.NdefMessageConverter", "message2MessageMap, messageMap: ".concat(String.valueOf(paramNdefMessage)));
    AppMethodBeat.o(183703);
    return paramNdefMessage;
  }
  
  public static Map<String, Object> bp(List<NdefMessage> paramList)
  {
    AppMethodBeat.i(183699);
    k.h(paramList, "messages");
    ad.d("MicroMsg.AppBrand.NdefMessageConverter", "messages2Map, messages: ".concat(String.valueOf(paramList)));
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(a((NdefMessage)((Iterator)localObject1).next()));
    }
    localObject1 = (List)paramList;
    Object localObject2 = (Iterable)localObject1;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramList.add((List)((o)((Iterator)localObject2).next()).first);
    }
    paramList = ae.b(new o[] { u.P("messages", (List)paramList) });
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.fvx();
      }
      localObject2 = ((Iterable)((o)localObject2).second).iterator();
      int j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (j < 0) {
          j.fvx();
        }
        localObject3 = (ByteBuffer)localObject3;
        paramList.put("payload-" + i + '-' + j, localObject3);
        j += 1;
      }
      i += 1;
    }
    ad.d("MicroMsg.AppBrand.NdefMessageConverter", "messages2Map, map: ".concat(String.valueOf(paramList)));
    AppMethodBeat.o(183699);
    return paramList;
  }
  
  public static NdefMessage bq(List<String> paramList)
  {
    AppMethodBeat.i(183701);
    k.h(paramList, "uris");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
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
        ad.w("MicroMsg.AppBrand.NdefMessageConverter", "createUri failed since ".concat(String.valueOf(paramList)));
        AppMethodBeat.o(183701);
        return null;
      }
    }
    paramList = ((Collection)paramList).toArray(new NdefRecord[0]);
    if (paramList == null)
    {
      paramList = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
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
        ad.w("MicroMsg.AppBrand.NdefMessageConverter", "create NdefMessage failed since ".concat(String.valueOf(paramList)));
        paramList = null;
      }
    }
  }
  
  public static NdefMessage br(List<? extends Map<String, String>> paramList)
  {
    AppMethodBeat.i(183702);
    k.h(paramList, "textAndLanguages");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
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
        ad.w("MicroMsg.AppBrand.NdefMessageConverter", "createTextRecord failed since ".concat(String.valueOf(paramList)));
        AppMethodBeat.o(183702);
        return null;
      }
    }
    paramList = ((Collection)paramList).toArray(new NdefRecord[0]);
    if (paramList == null)
    {
      paramList = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
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
        ad.w("MicroMsg.AppBrand.NdefMessageConverter", "create NdefMessage failed since ".concat(String.valueOf(paramList)));
        paramList = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.ball.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

final class BallInfo$a
  extends JSONObject
{
  public BallInfo$a(Object paramObject)
  {
    AppMethodBeat.i(127526);
    if ((paramObject instanceof String))
    {
      put("type", 1);
      put("val", paramObject);
      AppMethodBeat.o(127526);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      put("type", 2);
      put("val", paramObject);
      AppMethodBeat.o(127526);
      return;
    }
    if ((paramObject instanceof Long))
    {
      put("type", 3);
      put("val", paramObject);
      AppMethodBeat.o(127526);
      return;
    }
    if ((paramObject instanceof Double))
    {
      put("type", 4);
      put("val", paramObject);
      AppMethodBeat.o(127526);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      put("type", 5);
      put("val", paramObject);
      AppMethodBeat.o(127526);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      put("type", 6);
      put("val", Base64.encodeToString((byte[])paramObject, 2));
      AppMethodBeat.o(127526);
      return;
    }
    ad.w("MicroMsg.BallInfo", "not support type, class:%s", new Object[] { paramObject.getClass() });
    put("type", 0);
    AppMethodBeat.o(127526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.model.BallInfo.a
 * JD-Core Version:    0.7.0.1
 */
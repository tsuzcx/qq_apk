package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
{
  public static String oP(int paramInt)
  {
    AppMethodBeat.i(105640);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("errType:" + paramInt + ", err:");
    switch (paramInt)
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    default: 
      ((StringBuilder)localObject).append("unknow error");
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(105640);
      return localObject;
      ((StringBuilder)localObject).append("error PCM record callback");
      continue;
      ((StringBuilder)localObject).append("init encoder fail, occur exception");
      continue;
      ((StringBuilder)localObject).append("encoder un initial occur exception");
      continue;
      ((StringBuilder)localObject).append("start record occur exception");
      continue;
      ((StringBuilder)localObject).append("resume record occur exception");
      continue;
      ((StringBuilder)localObject).append("fail to start record");
      continue;
      ((StringBuilder)localObject).append("fail to resume record");
      continue;
      ((StringBuilder)localObject).append("fail to pause record");
      continue;
      ((StringBuilder)localObject).append("fail to stop record");
      continue;
      ((StringBuilder)localObject).append("check param invalid");
      continue;
      ((StringBuilder)localObject).append("not support format type");
      continue;
      ((StringBuilder)localObject).append("fail to init mp3 encoder");
      continue;
      ((StringBuilder)localObject).append("mp3 file not found exception");
      continue;
      ((StringBuilder)localObject).append("mp3 encode exception");
      continue;
      ((StringBuilder)localObject).append("mp3 write buffer exception");
      continue;
      ((StringBuilder)localObject).append("fail to init aac encoder");
      continue;
      ((StringBuilder)localObject).append("fail to create mp4 file");
      continue;
      ((StringBuilder)localObject).append("aac encode exception");
      continue;
      ((StringBuilder)localObject).append("create cache file fail");
      continue;
      ((StringBuilder)localObject).append("init encoder fail");
      continue;
      ((StringBuilder)localObject).append("not support sample rate");
    }
  }
  
  public static int oQ(int paramInt)
  {
    AppMethodBeat.i(105641);
    ab.i("MicroMsg.Record.RecordErrorHandler", "getErrIdKey errType:%d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    default: 
      AppMethodBeat.o(105641);
      return 0;
    case 1: 
      AppMethodBeat.o(105641);
      return 3;
    case 2: 
      AppMethodBeat.o(105641);
      return 4;
    case 3: 
      AppMethodBeat.o(105641);
      return 5;
    case 4: 
      AppMethodBeat.o(105641);
      return 6;
    case 5: 
      AppMethodBeat.o(105641);
      return 7;
    case 6: 
      AppMethodBeat.o(105641);
      return 8;
    case 7: 
      AppMethodBeat.o(105641);
      return 9;
    case 8: 
      AppMethodBeat.o(105641);
      return 10;
    case 9: 
      AppMethodBeat.o(105641);
      return 11;
    case 15: 
      AppMethodBeat.o(105641);
      return 15;
    case 16: 
      AppMethodBeat.o(105641);
      return 16;
    case 17: 
      AppMethodBeat.o(105641);
      return 17;
    case 18: 
      AppMethodBeat.o(105641);
      return 18;
    case 19: 
      AppMethodBeat.o(105641);
      return 19;
    case 20: 
      AppMethodBeat.o(105641);
      return 20;
    case 21: 
      AppMethodBeat.o(105641);
      return 21;
    case 22: 
      AppMethodBeat.o(105641);
      return 22;
    case 23: 
      AppMethodBeat.o(105641);
      return 23;
    case 24: 
      AppMethodBeat.o(105641);
      return 24;
    case 25: 
      AppMethodBeat.o(105641);
      return 25;
    }
    AppMethodBeat.o(105641);
    return 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.i
 * JD-Core Version:    0.7.0.1
 */
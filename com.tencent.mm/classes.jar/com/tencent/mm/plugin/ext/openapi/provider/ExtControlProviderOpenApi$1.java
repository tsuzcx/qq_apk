package com.tencent.mm.plugin.ext.openapi.provider;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.protocal.protobuf.eyx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SyncTask;
import java.util.Iterator;
import java.util.LinkedList;

final class ExtControlProviderOpenApi$1
  extends SyncTask<Cursor>
{
  ExtControlProviderOpenApi$1(ExtControlProviderOpenApi paramExtControlProviderOpenApi, Cursor paramCursor, String[] paramArrayOfString)
  {
    super(20000L, paramCursor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.1
 * JD-Core Version:    0.7.0.1
 */
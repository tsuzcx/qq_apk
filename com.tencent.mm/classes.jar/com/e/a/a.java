package com.e.a;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
{
  final int azO;
  final boolean bYl;
  SQLiteDatabase bYm;
  final int id;
  final String path;
  
  a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.path = paramString;
    this.bYl = paramBoolean;
    this.id = paramInt1;
    this.azO = paramInt2;
  }
  
  final String Au()
  {
    AppMethodBeat.i(153352);
    Object localObject = Thread.currentThread();
    localObject = this.id + "," + ((Thread)localObject).getName() + "(" + ((Thread)localObject).getId() + ")";
    AppMethodBeat.o(153352);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.e.a.a
 * JD-Core Version:    0.7.0.1
 */
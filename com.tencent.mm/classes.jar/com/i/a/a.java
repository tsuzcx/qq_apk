package com.i.a;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
{
  final boolean ecD;
  SQLiteDatabase ecE;
  boolean ecF;
  final int id;
  final int logLevel;
  final String path;
  
  a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.path = paramString;
    this.ecD = paramBoolean;
    this.id = paramInt1;
    this.logLevel = paramInt2;
  }
  
  final String alt()
  {
    AppMethodBeat.i(153352);
    Object localObject = new StringBuilder("[");
    Thread localThread = Thread.currentThread();
    localObject = new StringBuilder().append(this.id).append(",").append(localThread.getName()).append("(").append(localThread.getId()).append(")").toString() + "] ";
    AppMethodBeat.o(153352);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.i.a.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.app;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

abstract class aa$a
{
  final SimpleDateFormat hhw = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
  final String hhx = this.hhw.format(new Date());
  
  abstract void execute();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.aa.a
 * JD-Core Version:    0.7.0.1
 */
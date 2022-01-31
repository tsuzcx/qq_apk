package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class m
  extends c
{
  final int a(char paramChar, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(57171);
    if (paramChar == ' ')
    {
      paramStringBuilder.append('\003');
      AppMethodBeat.o(57171);
      return 1;
    }
    if ((paramChar >= '0') && (paramChar <= '9'))
    {
      paramStringBuilder.append((char)(paramChar - '0' + 4));
      AppMethodBeat.o(57171);
      return 1;
    }
    if ((paramChar >= 'a') && (paramChar <= 'z'))
    {
      paramStringBuilder.append((char)(paramChar - 'a' + 14));
      AppMethodBeat.o(57171);
      return 1;
    }
    if ((paramChar >= 0) && (paramChar <= '\037'))
    {
      paramStringBuilder.append('\000');
      paramStringBuilder.append(paramChar);
      AppMethodBeat.o(57171);
      return 2;
    }
    if ((paramChar >= '!') && (paramChar <= '/'))
    {
      paramStringBuilder.append('\001');
      paramStringBuilder.append((char)(paramChar - '!'));
      AppMethodBeat.o(57171);
      return 2;
    }
    if ((paramChar >= ':') && (paramChar <= '@'))
    {
      paramStringBuilder.append('\001');
      paramStringBuilder.append((char)(paramChar - ':' + 15));
      AppMethodBeat.o(57171);
      return 2;
    }
    if ((paramChar >= '[') && (paramChar <= '_'))
    {
      paramStringBuilder.append('\001');
      paramStringBuilder.append((char)(paramChar - '[' + 22));
      AppMethodBeat.o(57171);
      return 2;
    }
    if (paramChar == '`')
    {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(paramChar - '`'));
      AppMethodBeat.o(57171);
      return 2;
    }
    if ((paramChar >= 'A') && (paramChar <= 'Z'))
    {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(paramChar - 'A' + 1));
      AppMethodBeat.o(57171);
      return 2;
    }
    if ((paramChar >= '{') && (paramChar <= ''))
    {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(paramChar - '{' + 27));
      AppMethodBeat.o(57171);
      return 2;
    }
    if (paramChar >= '')
    {
      paramStringBuilder.append("\001\036");
      int i = a((char)(paramChar - ''), paramStringBuilder);
      AppMethodBeat.o(57171);
      return i + 2;
    }
    j.k(paramChar);
    AppMethodBeat.o(57171);
    return -1;
  }
  
  public final int sC()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.b.c.a.m
 * JD-Core Version:    0.7.0.1
 */
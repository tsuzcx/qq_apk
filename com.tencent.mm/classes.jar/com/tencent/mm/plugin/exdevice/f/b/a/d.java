package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.h.c.cg;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends cg
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "rankID";
    locala.ujN.put("rankID", "TEXT");
    localStringBuilder.append(" rankID TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "appusername";
    locala.ujN.put("appusername", "TEXT");
    localStringBuilder.append(" appusername TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "username";
    locala.ujN.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "ranknum";
    locala.ujN.put("ranknum", "INTEGER");
    localStringBuilder.append(" ranknum INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "score";
    locala.ujN.put("score", "INTEGER");
    localStringBuilder.append(" score INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "likecount";
    locala.ujN.put("likecount", "INTEGER default '0' ");
    localStringBuilder.append(" likecount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "selfLikeState";
    locala.ujN.put("selfLikeState", "INTEGER default '3' ");
    localStringBuilder.append(" selfLikeState INTEGER default '3' ");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final String toString()
  {
    String str = "{" + "username: " + this.field_username + " ranknum: " + this.field_ranknum + " score: " + this.field_score;
    str = str + " likeCount:" + this.field_likecount + " selfLikeState:" + this.field_selfLikeState;
    return str + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.a.d
 * JD-Core Version:    0.7.0.1
 */
package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

final class c$e
  extends AsyncTask<Object, Void, Void>
{
  c$e(c paramc) {}
  
  private Void b(Object... paramVarArgs)
  {
    int i = 0;
    List localList = (List)paramVarArgs[0];
    paramVarArgs = (String)paramVarArgs[1];
    for (;;)
    {
      try
      {
        paramVarArgs = this.Zr.mContext.openFileOutput(paramVarArgs, 0);
        localXmlSerializer = Xml.newSerializer();
        int j;
        c.c localc;
        localXmlSerializer.endTag(null, "historical-records");
      }
      catch (FileNotFoundException paramVarArgs)
      {
        try
        {
          localXmlSerializer.setOutput(paramVarArgs, null);
          localXmlSerializer.startDocument("UTF-8", Boolean.TRUE);
          localXmlSerializer.startTag(null, "historical-records");
          j = localList.size();
          if (i >= j) {
            break label186;
          }
          localc = (c.c)localList.remove(0);
          localXmlSerializer.startTag(null, "historical-record");
          localXmlSerializer.attribute(null, "activity", localc.Zq.flattenToString());
          localXmlSerializer.attribute(null, "time", String.valueOf(localc.time));
          localXmlSerializer.attribute(null, "weight", String.valueOf(localc.weight));
          localXmlSerializer.endTag(null, "historical-record");
          i += 1;
          continue;
          paramVarArgs = paramVarArgs;
          paramVarArgs = c.LOG_TAG;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          XmlSerializer localXmlSerializer;
          String str1 = c.LOG_TAG;
          new StringBuilder("Error writing historical record file: ").append(this.Zr.Zi);
          this.Zr.Zl = true;
          if (paramVarArgs == null) {
            continue;
          }
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          String str2 = c.LOG_TAG;
          new StringBuilder("Error writing historical record file: ").append(this.Zr.Zi);
          this.Zr.Zl = true;
          if (paramVarArgs == null) {
            continue;
          }
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
        catch (IOException localIOException)
        {
          String str3 = c.LOG_TAG;
          new StringBuilder("Error writing historical record file: ").append(this.Zr.Zi);
          this.Zr.Zl = true;
          if (paramVarArgs == null) {
            continue;
          }
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
        finally
        {
          this.Zr.Zl = true;
          if (paramVarArgs == null) {
            break label387;
          }
        }
        return null;
      }
      label186:
      localXmlSerializer.endDocument();
      this.Zr.Zl = true;
      if (paramVarArgs != null) {
        try
        {
          paramVarArgs.close();
          return null;
        }
        catch (IOException paramVarArgs)
        {
          return null;
        }
      }
    }
    try
    {
      paramVarArgs.close();
      label387:
      throw localObject;
    }
    catch (IOException paramVarArgs)
    {
      break label387;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.c.e
 * JD-Core Version:    0.7.0.1
 */
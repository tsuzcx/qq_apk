package com.tencent.qqprotect.singleupdate;

import android.content.Context;
import android.util.Xml;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

public class EmulatorDetectFactory
{
  private static final byte jdField_a_of_type_Byte = 18;
  private static String jdField_a_of_type_JavaLangString = null;
  private static final String jdField_c_of_type_JavaLangString = "EmulatorDetect";
  private EDEntity jdField_a_of_type_ComTencentQqprotectSingleupdateEDEntity;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean jdField_c_of_type_Boolean;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  
  public EmulatorDetectFactory()
  {
    this.c = false;
    File localFile = BaseApplication.getContext().getFilesDir();
    jdField_a_of_type_JavaLangString = localFile.getAbsolutePath() + "/QPfile";
    localFile = new File(jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("EmulatorDetect", 2, "EmulatorDetectFactory");
    }
    if (!localFile.exists())
    {
      localFile.mkdir();
      if (QLog.isColorLevel()) {
        QLog.d("EmulatorDetect", 2, "EmulatorDetectFactory file.mkdir()");
      }
    }
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateEDEntity = new EDEntity();
  }
  
  public static boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (jdField_a_of_type_JavaLangString != null)
    {
      File localFile = new File(jdField_a_of_type_JavaLangString);
      bool1 = bool2;
      if (localFile.exists()) {
        bool1 = localFile.delete();
      }
    }
    return bool1;
  }
  
  public int a(String paramString)
  {
    Object localObject = a(paramString);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmulatorDetect", 2, "InputStream = null, use default detect!!!");
      }
      if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateEDEntity.a()) {
        return 2;
      }
      return 4;
    }
    paramString = Xml.newPullParser();
    paramString.setInput((InputStream)localObject, "UTF-8");
    int k = paramString.getEventType();
    int i;
    for (int j = 3;; j = i)
    {
      i = j;
      if (k != 1)
      {
        i = j;
        switch (k)
        {
        default: 
          i = j;
        }
      }
      while ((1 == i) || (2 == i))
      {
        this.jdField_a_of_type_JavaUtilMap.clear();
        a(jdField_a_of_type_JavaLangString + "/emulator.xml");
        return i;
        paramString.getName();
        paramString.getText();
        i = j;
        continue;
        localObject = paramString.getName();
        i = j;
        if (!((String)localObject).equals("emulatordetect")) {
          if (((String)localObject).equals("emulatorapn"))
          {
            this.jdField_a_of_type_Boolean = true;
            i = j;
          }
          else if (((String)localObject).equals("emulatordrivers"))
          {
            this.jdField_b_of_type_Boolean = true;
            i = j;
          }
          else if (((String)localObject).equals("emulatorfiles"))
          {
            this.c = true;
            i = j;
          }
          else if (((String)localObject).equals("emulatorphonestate"))
          {
            this.d = true;
            i = j;
          }
          else if (((String)localObject).equals("emulatorcpu"))
          {
            this.e = true;
            i = j;
          }
          else if (((String)localObject).equals("emulatorhardware"))
          {
            this.f = true;
            i = j;
          }
          else if (((String)localObject).equals("emulatorprocess"))
          {
            this.g = true;
            i = j;
          }
          else
          {
            String str = paramString.getAttributeValue(0);
            i = j;
            if (str.length() != 0)
            {
              this.jdField_a_of_type_JavaUtilMap.put(localObject, str);
              i = j;
              continue;
              localObject = paramString.getName();
              if ((true == this.jdField_a_of_type_Boolean) && (((String)localObject).equals("emulatorapn")))
              {
                this.jdField_a_of_type_Boolean = false;
                i = j;
                if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateEDEntity.a(this.jdField_a_of_type_JavaUtilMap)) {
                  i = 1;
                }
              }
              else if ((true == this.jdField_b_of_type_Boolean) && (((String)localObject).equals("emulatordrivers")))
              {
                this.jdField_b_of_type_Boolean = false;
                i = j;
                if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateEDEntity.d(this.jdField_a_of_type_JavaUtilMap)) {
                  i = 1;
                }
              }
              else if ((true == this.c) && (((String)localObject).equals("emulatorfiles")))
              {
                this.c = false;
                this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
                i = j;
                if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateEDEntity.c(this.jdField_a_of_type_JavaUtilMap)) {
                  i = 1;
                }
              }
              else if ((true == this.d) && (((String)localObject).equals("emulatorphonestate")))
              {
                this.d = false;
                i = j;
                if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateEDEntity.e(this.jdField_a_of_type_JavaUtilMap)) {
                  i = 1;
                }
              }
              else if ((true == this.e) && (((String)localObject).equals("emulatorcpu")))
              {
                this.e = false;
                i = j;
                if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateEDEntity.f(this.jdField_a_of_type_JavaUtilMap)) {
                  i = 1;
                }
              }
              else if ((true == this.f) && (((String)localObject).equals("emulatorhardware")))
              {
                this.f = false;
                i = j;
                if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateEDEntity.g(this.jdField_a_of_type_JavaUtilMap)) {
                  i = 1;
                }
              }
              else
              {
                i = j;
                if (true == this.g)
                {
                  i = j;
                  if (((String)localObject).equals("emulatorprocess"))
                  {
                    this.g = false;
                    i = j;
                    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateEDEntity.b(this.jdField_a_of_type_JavaUtilMap)) {
                      i = 1;
                    }
                  }
                }
              }
            }
          }
        }
      }
      k = paramString.next();
    }
  }
  
  public InputStream a(String paramString)
  {
    try
    {
      paramString = jdField_a_of_type_JavaLangString + "/" + paramString;
      if (!new File(paramString).exists())
      {
        if (QLog.isColorLevel())
        {
          QLog.d("EmulatorDetect", 2, "filePath = null " + paramString);
          return null;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmulatorDetect", 2, "filePath = " + paramString);
        }
        String str = jdField_a_of_type_JavaLangString + "/emulator.xml";
        a(paramString, str);
        paramString = new FileInputStream(str);
        return paramString;
      }
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("EmulatorDetect", 2, paramString.toString());
      }
    }
    return null;
  }
  
  public Map a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.exists())
    {
      localFile.delete();
      if (QLog.isColorLevel()) {
        QLog.d("EmulatorDetect", 2, "delete " + paramString);
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    File localFile = new File(paramString2);
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
    }
    catch (IOException localIOException)
    {
      try
      {
        paramString1 = new DataInputStream(new FileInputStream(paramString1));
        paramString2 = new DataOutputStream(new FileOutputStream(paramString2));
        while (paramString1.available() != 0) {
          paramString2.writeByte((byte)(paramString1.readByte() ^ 0x12));
        }
      }
      catch (FileNotFoundException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          return false;
          localIOException = localIOException;
          localIOException.printStackTrace();
        }
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.EmulatorDetectFactory
 * JD-Core Version:    0.7.0.1
 */
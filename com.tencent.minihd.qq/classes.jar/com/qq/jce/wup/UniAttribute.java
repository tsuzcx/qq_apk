package com.qq.jce.wup;

import TT;;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class UniAttribute
  extends OldUniAttribute
{
  JceInputStream _is = new JceInputStream();
  protected HashMap<String, byte[]> _newData = null;
  private HashMap<String, Object> cachedData = new HashMap();
  
  private Object decodeData(byte[] paramArrayOfByte, Object paramObject)
  {
    this._is.wrap(paramArrayOfByte);
    this._is.setServerEncoding(this.encodeName);
    return this._is.read(paramObject, 0, true);
  }
  
  private void saveDataCache(String paramString, Object paramObject)
  {
    this.cachedData.put(paramString, paramObject);
  }
  
  public void clearCacheData()
  {
    this.cachedData.clear();
  }
  
  public boolean containsKey(String paramString)
  {
    if (this._newData != null) {
      return this._newData.containsKey(paramString);
    }
    return this._data.containsKey(paramString);
  }
  
  public void decode(byte[] paramArrayOfByte)
  {
    try
    {
      super.decode(paramArrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      this._is.wrap(paramArrayOfByte);
      this._is.setServerEncoding(this.encodeName);
      paramArrayOfByte = new HashMap(1);
      paramArrayOfByte.put("", new byte[0]);
      this._newData = this._is.readMap(paramArrayOfByte, 0, false);
    }
  }
  
  public void decodeVersion2(byte[] paramArrayOfByte)
  {
    super.decode(paramArrayOfByte);
  }
  
  public void decodeVersion3(byte[] paramArrayOfByte)
  {
    this._is.wrap(paramArrayOfByte);
    this._is.setServerEncoding(this.encodeName);
    paramArrayOfByte = new HashMap(1);
    paramArrayOfByte.put("", new byte[0]);
    this._newData = this._is.readMap(paramArrayOfByte, 0, false);
  }
  
  public byte[] encode()
  {
    if (this._newData != null)
    {
      JceOutputStream localJceOutputStream = new JceOutputStream(0);
      localJceOutputStream.setServerEncoding(this.encodeName);
      localJceOutputStream.write(this._newData, 0);
      return JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
    }
    return super.encode();
  }
  
  public <T> T get(String paramString)
    throws ObjectCreateException
  {
    if (this._newData != null) {
      throw new RuntimeException("data is encoded by new version, please use getByClass(String name, T proxy)");
    }
    return super.get(paramString);
  }
  
  public <T> T get(String paramString, Object paramObject)
  {
    if (this._newData != null) {
      throw new RuntimeException("data is encoded by new version, please use get(String name, T proxy, Object defaultValue)");
    }
    return super.get(paramString, paramObject);
  }
  
  public <T> T get(String paramString, T paramT, Object paramObject)
  {
    if (!this._newData.containsKey(paramString)) {
      return paramObject;
    }
    return getByClass(paramString, paramT);
  }
  
  public <T> T getByClass(String paramString, T paramT)
    throws ObjectCreateException
  {
    Object localObject1 = null;
    if (this._newData != null) {
      if (this._newData.containsKey(paramString)) {}
    }
    while (!this._data.containsKey(paramString)) {
      for (;;)
      {
        return localObject1;
        if (this.cachedData.containsKey(paramString)) {
          return this.cachedData.get(paramString);
        }
        localObject1 = (byte[])this._newData.get(paramString);
        try
        {
          paramT = decodeData((byte[])localObject1, paramT);
          localObject1 = paramT;
          if (paramT != null)
          {
            saveDataCache(paramString, paramT);
            return paramT;
          }
        }
        catch (Exception paramString)
        {
          throw new ObjectCreateException(paramString);
        }
      }
    }
    if (this.cachedData.containsKey(paramString)) {
      return this.cachedData.get(paramString);
    }
    Object localObject2 = (HashMap)this._data.get(paramString);
    localObject1 = new byte[0];
    localObject2 = ((HashMap)localObject2).entrySet().iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      localObject2 = (String)((Map.Entry)localObject1).getKey();
      localObject1 = (byte[])((Map.Entry)localObject1).getValue();
    }
    try
    {
      this._is.wrap((byte[])localObject1);
      this._is.setServerEncoding(this.encodeName);
      paramT = this._is.read(paramT, 0, true);
      saveDataCache(paramString, paramT);
      return paramT;
    }
    catch (Exception paramString)
    {
      throw new ObjectCreateException(paramString);
    }
  }
  
  public <T> T getByClass(String paramString, T paramT1, T paramT2)
    throws ObjectCreateException
  {
    if (this._newData != null) {
      if (this._newData.containsKey(paramString)) {}
    }
    while (!this._data.containsKey(paramString))
    {
      return paramT2;
      if (this.cachedData.containsKey(paramString)) {
        return this.cachedData.get(paramString);
      }
      paramT2 = (byte[])this._newData.get(paramString);
      try
      {
        paramT1 = decodeData(paramT2, paramT1);
        if (paramT1 != null) {
          saveDataCache(paramString, paramT1);
        }
        return paramT1;
      }
      catch (Exception paramString)
      {
        throw new ObjectCreateException(paramString);
      }
    }
    if (this.cachedData.containsKey(paramString)) {
      return this.cachedData.get(paramString);
    }
    Object localObject = (HashMap)this._data.get(paramString);
    paramT2 = new byte[0];
    localObject = ((HashMap)localObject).entrySet().iterator();
    if (((Iterator)localObject).hasNext())
    {
      paramT2 = (Map.Entry)((Iterator)localObject).next();
      localObject = (String)paramT2.getKey();
      paramT2 = (byte[])paramT2.getValue();
    }
    try
    {
      this._is.wrap(paramT2);
      this._is.setServerEncoding(this.encodeName);
      paramT1 = this._is.read(paramT1, 0, true);
      saveDataCache(paramString, paramT1);
      return paramT1;
    }
    catch (Exception paramString)
    {
      throw new ObjectCreateException(paramString);
    }
  }
  
  public <T> T getJceStruct(String paramString)
    throws ObjectCreateException
  {
    if (this._newData != null) {
      throw new RuntimeException("data is encoded by new version, please use getJceStruct(String name,T proxy)");
    }
    return super.getJceStruct(paramString);
  }
  
  public <T> T getJceStruct(String paramString, T paramT)
    throws ObjectCreateException
  {
    if (!this._newData.containsKey(paramString)) {
      paramT = null;
    }
    for (;;)
    {
      return paramT;
      if (this.cachedData.containsKey(paramString)) {
        return this.cachedData.get(paramString);
      }
      Object localObject = (byte[])this._newData.get(paramString);
      try
      {
        localObject = decodeData((byte[])localObject, paramT);
        paramT = (TT)localObject;
        if (localObject == null) {
          continue;
        }
        saveDataCache(paramString, localObject);
        return localObject;
      }
      catch (Exception paramString)
      {
        throw new ObjectCreateException(paramString);
      }
    }
  }
  
  public Set<String> getKeySet()
  {
    if (this._newData != null) {
      return Collections.unmodifiableSet(this._newData.keySet());
    }
    return Collections.unmodifiableSet(this._data.keySet());
  }
  
  public boolean isEmpty()
  {
    if (this._newData != null) {
      return this._newData.isEmpty();
    }
    return this._data.isEmpty();
  }
  
  public <T> void put(String paramString, T paramT)
  {
    if (this._newData != null)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("put key can not is null");
      }
      if (paramT == null) {
        throw new IllegalArgumentException("put value can not is null");
      }
      if ((paramT instanceof Set)) {
        throw new IllegalArgumentException("can not support Set");
      }
      JceOutputStream localJceOutputStream = new JceOutputStream();
      localJceOutputStream.setServerEncoding(this.encodeName);
      localJceOutputStream.write(paramT, 0);
      paramT = JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
      this._newData.put(paramString, paramT);
      return;
    }
    super.put(paramString, paramT);
  }
  
  public <T> T remove(String paramString)
    throws ObjectCreateException
  {
    if (this._newData != null)
    {
      if (!this._newData.containsKey(paramString)) {
        return null;
      }
      this._newData.remove(paramString);
      return null;
    }
    return super.remove(paramString);
  }
  
  public <T> T remove(String paramString, T paramT)
    throws ObjectCreateException
  {
    if (!this._newData.containsKey(paramString)) {
      return null;
    }
    if (paramT != null) {
      return decodeData((byte[])this._newData.remove(paramString), paramT);
    }
    this._newData.remove(paramString);
    return null;
  }
  
  public int size()
  {
    if (this._newData != null) {
      return this._newData.size();
    }
    return this._data.size();
  }
  
  public void useVersion3()
  {
    this._newData = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.qq.jce.wup.UniAttribute
 * JD-Core Version:    0.7.0.1
 */
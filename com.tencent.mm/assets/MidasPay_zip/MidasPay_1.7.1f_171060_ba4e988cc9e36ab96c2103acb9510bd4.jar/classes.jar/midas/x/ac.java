package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ac
{
  private static volatile ac a;
  private ArrayList<q> b = null;
  private r c = null;
  private q d = null;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private String h;
  private String i = "";
  
  private int a(int paramInt, ArrayList<q> paramArrayList)
  {
    paramArrayList = b(paramInt, this.b);
    if (paramArrayList != null) {
      return paramArrayList.b.a(paramInt);
    }
    return 0;
  }
  
  private String a(ArrayList<v> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayList != null)
    {
      int j = 0;
      while (j < paramArrayList.size())
      {
        localStringBuffer.append(((v)paramArrayList.get(j)).a);
        localStringBuffer.append('×');
        localStringBuffer.append(((v)paramArrayList.get(j)).b);
        localStringBuffer.append(65292);
        j += 1;
      }
      if (localStringBuffer.length() > 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
    }
    return localStringBuffer.toString();
  }
  
  public static ac a()
  {
    try
    {
      if (a == null) {
        try
        {
          if (a == null) {
            a = new ac();
          }
        }
        finally {}
      }
      ac localac = a;
      return localac;
    }
    finally {}
  }
  
  private ad a(int paramInt, q paramq)
  {
    ad localad1 = paramq.a;
    ad localad2 = paramq.b;
    int j = 0;
    if ((localad2 != null) && (localad1 == null)) {}
    try
    {
      j = localad2.b.a;
    }
    catch (Exception paramq)
    {
      label36:
      break label36;
    }
    j = 0;
    if (paramInt == j)
    {
      return localad2;
      if ((localad2 != null) || (localad1 == null)) {}
    }
    try
    {
      j = localad1.b.a;
    }
    catch (Exception paramq)
    {
      label68:
      break label68;
    }
    j = 0;
    if (paramInt >= j)
    {
      return localad1;
      if ((localad2 == null) || (localad1 == null)) {}
    }
    try
    {
      k = localad1.b.a;
    }
    catch (Exception localException1)
    {
      int k;
      int m;
      label114:
      break label114;
    }
    try
    {
      m = localad2.b.a;
      j = m;
    }
    catch (Exception localException2)
    {
      break label117;
    }
    k = 0;
    label117:
    if ((paramInt == j) && (paramInt < k)) {
      return localad2;
    }
    if ((paramInt != j) && (paramInt >= k)) {
      return localad1;
    }
    if ((paramInt == j) && (paramInt >= k)) {
      return a(paramq);
    }
    return null;
  }
  
  private ad a(q paramq)
  {
    if ((paramq.b == null) && (paramq.a == null)) {
      return null;
    }
    if (paramq.b == null) {
      return paramq.a;
    }
    if (paramq.a == null) {
      return paramq.b;
    }
    localObject3 = "";
    Object localObject1 = localObject3;
    try
    {
      if (paramq.a.b != null)
      {
        localObject1 = localObject3;
        if (!TextUtils.isEmpty(paramq.a.b.e)) {
          localObject1 = paramq.a.b.e;
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localObject2 = localObject3;
      }
    }
    str = "";
    localObject3 = str;
    try
    {
      if (paramq.b.b != null)
      {
        localObject3 = str;
        if (!TextUtils.isEmpty(paramq.b.b.e)) {
          localObject3 = paramq.b.b.e;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject4 = str;
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject3))) {
      return paramq.b;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject3))) {
      return paramq.a;
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
      return paramq.b;
    }
    return paramq.b;
  }
  
  private void a(w paramw, JSONArray paramJSONArray, String paramString)
  {
    try
    {
      int k = paramJSONArray.length();
      int j = 0;
      while (j < k)
      {
        JSONObject localJSONObject = (JSONObject)paramJSONArray.get(j);
        if (paramString.equals(localJSONObject.getString("flag")))
        {
          paramJSONArray = new x();
          paramJSONArray.b(localJSONObject.getString("activitymeta"));
          paramJSONArray.a(localJSONObject.getString("activityname"));
          paramJSONArray.k(localJSONObject.getString("currenttime"));
          paramJSONArray.l(localJSONObject.getString("endtime"));
          paramJSONArray.o(localJSONObject.getString("extend"));
          paramJSONArray.n(localJSONObject.getString("flag"));
          paramJSONArray.d(localJSONObject.getString("goodsmeta"));
          paramJSONArray.c(localJSONObject.getString("goodsname"));
          paramJSONArray.m(localJSONObject.getString("img"));
          paramJSONArray.g(localJSONObject.getString("minparticipants"));
          paramJSONArray.e(d(localJSONObject.getString("originalprice")));
          paramJSONArray.h(localJSONObject.getString("participants"));
          paramJSONArray.f(d(localJSONObject.getString("price")));
          paramJSONArray.i(localJSONObject.getString("productid"));
          paramJSONArray.j(localJSONObject.getString("starttime"));
          paramw.a(paramJSONArray);
          paramw.a("1");
          return;
        }
        j += 1;
      }
      return;
    }
    catch (JSONException paramw)
    {
      paramw.printStackTrace();
    }
  }
  
  private boolean a(JSONArray paramJSONArray, String paramString)
  {
    try
    {
      int k = paramJSONArray.length();
      int j = 0;
      while (j < k)
      {
        boolean bool = paramString.equals(((JSONObject)paramJSONArray.get(j)).getString("flag"));
        if (bool) {
          return true;
        }
        j += 1;
      }
      return false;
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  private ad b(int paramInt, ArrayList<q> paramArrayList)
  {
    int j;
    Object localObject;
    if (paramArrayList != null)
    {
      j = 0;
      if (j < paramArrayList.size()) {
        localObject = (q)paramArrayList.get(j);
      }
    }
    for (;;)
    {
      try
      {
        if ((((q)localObject).a == null) || (((q)localObject).a.b == null)) {
          break label205;
        }
        k = ((q)localObject).a.b.a;
        if ((((q)localObject).b == null) || (((q)localObject).b.b == null)) {
          break label211;
        }
        m = ((q)localObject).b.b.a;
        if ((paramInt == k) && (paramInt != m)) {
          return ((q)localObject).a;
        }
        if ((paramInt != k) && (paramInt == m)) {
          return ((q)localObject).b;
        }
        if ((paramInt == k) && (paramInt == m))
        {
          localObject = a((q)localObject);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        APLog.w("getLevelType", localException.toString());
        j += 1;
      }
      break;
      paramInt = c(paramInt, paramArrayList);
      if ((paramInt >= 0) && (paramInt < paramArrayList.size())) {
        return ((q)paramArrayList.get(paramInt)).a;
      }
      return null;
      label205:
      int k = 0;
      continue;
      label211:
      int m = 0;
    }
  }
  
  private int c(int paramInt, ArrayList<q> paramArrayList)
  {
    k = -1;
    n = k;
    if (paramArrayList != null)
    {
      int j = 0;
      for (m = -1;; m = n)
      {
        n = k;
        if (j >= paramArrayList.size()) {
          break;
        }
        q localq = (q)paramArrayList.get(j);
        try
        {
          int i2 = localq.a.b.a;
          i1 = k;
          n = m;
          if (paramInt >= i2)
          {
            i1 = k;
            n = m;
            if (i2 > m)
            {
              i1 = j;
              n = i2;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i1 = k;
            n = m;
          }
        }
        j += 1;
        k = i1;
      }
    }
    else
    {
      return n;
    }
  }
  
  private String d(String paramString)
  {
    float f1 = Float.valueOf(APTools.i(paramString)).floatValue() / 100.0F;
    paramString = new DecimalFormat();
    paramString.applyPattern("0.00");
    return paramString.format(f1);
  }
  
  private q f(JSONObject paramJSONObject)
  {
    q localq = new q();
    try
    {
      ad localad = g(paramJSONObject);
      localad.a = 1;
      localq.a = localad;
      if (paramJSONObject.has("single_ex"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("single_ex");
        if (paramJSONObject != null)
        {
          paramJSONObject = g(paramJSONObject.getJSONObject(0));
          paramJSONObject.a = 2;
          localq.b = paramJSONObject;
          return localq;
        }
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localq;
  }
  
  private ad g(JSONObject paramJSONObject)
  {
    ad localad = new ad();
    Object localObject = new s();
    try
    {
      if (paramJSONObject.has("num")) {
        ((s)localObject).a = i.a(paramJSONObject.getString("num"));
      }
      if (paramJSONObject.has("send_rate")) {
        ((s)localObject).b = i.a(paramJSONObject.getString("send_rate"));
      }
      if (paramJSONObject.has("send_num")) {
        ((s)localObject).c = i.a(paramJSONObject.getString("send_num"));
      }
      if (paramJSONObject.has("send_type")) {
        ((s)localObject).d = paramJSONObject.getString("send_type");
      }
      if (paramJSONObject.has("send_ext")) {
        ((s)localObject).e = paramJSONObject.getString("send_ext");
      }
      localad.b = ((s)localObject);
      if (paramJSONObject.has("ex_send"))
      {
        localObject = new ArrayList();
        paramJSONObject = paramJSONObject.getJSONArray("ex_send");
        int j = 0;
        while (j < paramJSONObject.length())
        {
          JSONObject localJSONObject = (JSONObject)paramJSONObject.get(j);
          v localv = new v();
          if (localJSONObject.has("name")) {
            localv.a = localJSONObject.getString("name");
          }
          if (localJSONObject.has("num")) {
            localv.b = localJSONObject.getString("num");
          }
          ((ArrayList)localObject).add(localv);
          j += 1;
        }
        localad.c = ((ArrayList)localObject);
        return localad;
      }
    }
    catch (Exception paramJSONObject)
    {
      APLog.w("analyzeSectionOrSingleMpItem", paramJSONObject.toString());
    }
    return localad;
  }
  
  private boolean g()
  {
    if (this.c != null) {
      return this.c.a() ^ true;
    }
    return false;
  }
  
  private ArrayList<q> h()
  {
    return this.b;
  }
  
  private String i()
  {
    return a(a(this.d).c);
  }
  
  private aa k(int paramInt)
  {
    if ((this.c != null) && (this.c.a != null) && (this.c.a.size() > paramInt)) {
      return (aa)this.c.a.get(paramInt);
    }
    return null;
  }
  
  private int l(int paramInt)
  {
    if (this.d == null) {
      return 0;
    }
    if ((this.d.b == null) && (this.d.a == null))
    {
      this.d = null;
      return 0;
    }
    int j;
    if ((this.d.a != null) && (this.d.a.b != null)) {
      j = this.d.a.b.a;
    } else {
      j = 0;
    }
    int k;
    if ((this.d.b != null) && (this.d.b.b != null)) {
      k = this.d.b.b.a;
    } else {
      k = 0;
    }
    if (paramInt == k) {
      return this.d.b.a(paramInt);
    }
    if (paramInt >= j) {
      return this.d.a.a(paramInt);
    }
    return 0;
  }
  
  private int m(int paramInt)
  {
    return a(paramInt, this.b);
  }
  
  private int n(int paramInt)
  {
    ad localad = b(paramInt, this.b);
    if (localad != null) {
      return localad.b.a;
    }
    return 0;
  }
  
  public ArrayList<v> a(ArrayList<v> paramArrayList1, ArrayList<v> paramArrayList2)
  {
    if ((paramArrayList1 == null) && (paramArrayList2 == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    v localv1;
    if (paramArrayList2 == null)
    {
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (v)paramArrayList1.next();
        localv1 = new v();
        localv1.a = paramArrayList2.a;
        localv1.b = paramArrayList2.b;
        localArrayList.add(localv1);
      }
      return localArrayList;
    }
    if (paramArrayList1 == null)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (v)paramArrayList1.next();
        localv1 = new v();
        localv1.a = paramArrayList2.a;
        localv1.b = paramArrayList2.b;
        localArrayList.add(localv1);
      }
      return localArrayList;
    }
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      localv1 = (v)paramArrayList1.next();
      v localv2 = new v();
      localv2.a = localv1.a;
      localv2.b = localv1.b;
      localArrayList.add(localv2);
    }
    paramArrayList1 = paramArrayList2.iterator();
    while (paramArrayList1.hasNext())
    {
      localv1 = (v)paramArrayList1.next();
      paramArrayList2 = new v();
      paramArrayList2.a = localv1.a;
      paramArrayList2.b = localv1.b;
      int m = 0;
      int j = 0;
      int k;
      for (;;)
      {
        k = m;
        if (j >= localArrayList.size()) {
          break;
        }
        localv1 = (v)localArrayList.get(j);
        if (localv1.a.equals(paramArrayList2.a))
        {
          localv1.b = String.valueOf(i.a(localv1.b) + i.a(paramArrayList2.b));
          k = 1;
          break;
        }
        j += 1;
      }
      if (k == 0) {
        localArrayList.add(paramArrayList2);
      }
    }
    return localArrayList;
  }
  
  public y a(int paramInt)
  {
    boolean bool = g();
    Object localObject2 = null;
    Object localObject3;
    Object localObject1;
    if (bool)
    {
      localObject3 = k(paramInt);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = new y();
        ((y)localObject1).a = ((aa)localObject3).a;
        ((y)localObject1).b = ((aa)localObject3).a(((y)localObject1).a);
        ((y)localObject1).c = ((aa)localObject3).b;
        ((y)localObject1).d = ((aa)localObject3).c;
        ((y)localObject1).e = ((aa)localObject3).a();
        return localObject1;
      }
    }
    else
    {
      localObject1 = localObject2;
      if (c())
      {
        localObject1 = localObject2;
        if (this.b != null)
        {
          localObject3 = a((q)this.b.get(paramInt));
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = new y();
            ((y)localObject1).a = ((ad)localObject3).b.a;
            ((y)localObject1).b = ((ad)localObject3).b.a();
            ((y)localObject1).c = ((ad)localObject3).b.e;
            ((y)localObject1).d = ((ad)localObject3).c;
            ((y)localObject1).e = ((ad)localObject3).b();
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
    if (this.b != null) {
      this.b.clear();
    }
    if (this.d != null) {
      this.d.a();
    }
    o.a().i();
    if (this.c != null) {
      this.c.d();
    }
    this.i = "";
    int k = 0;
    this.e = false;
    this.f = false;
    this.g = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      int j;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("first_mpinfo"))
        {
          this.d = f(paramString.getJSONObject("first_mpinfo"));
          if (a(this.d).a()) {
            this.e = true;
          } else {
            this.e = false;
          }
        }
        Object localObject1;
        Object localObject2;
        Object localObject3;
        if (paramString.has("utp_mpinfo"))
        {
          localObject1 = paramString.getJSONArray("utp_mpinfo");
          j = 0;
          if (j < ((JSONArray)localObject1).length())
          {
            localObject2 = f(((JSONArray)localObject1).getJSONObject(j));
            localObject3 = a((q)localObject2);
            if (((ad)localObject3).a()) {
              this.f = true;
            }
            if (((ad)localObject3).c()) {
              this.g = true;
            }
            this.b.add(localObject2);
            j += 1;
            continue;
          }
        }
        if (paramString.has("utp_mpinfo_detail"))
        {
          localObject1 = paramString.getJSONObject("utp_mpinfo_detail");
          this.c.a((JSONObject)localObject1);
          if ((this.c.b()) || (this.c.c())) {
            this.f = true;
          }
          if (this.c.c()) {
            this.g = true;
          }
        }
        o.a().i();
        if (paramString.has("gold_mpinfo"))
        {
          localObject1 = paramString.getJSONObject("gold_mpinfo");
          Object localObject5;
          String str;
          Object localObject4;
          if ((localObject1 != null) && (((JSONObject)localObject1).has("resinfo")))
          {
            localObject2 = ((JSONObject)localObject1).getJSONArray("resinfo");
            j = 0;
            if (j < ((JSONArray)localObject2).length())
            {
              localObject5 = ((JSONArray)localObject2).getJSONObject(j);
              localObject3 = ((JSONObject)localObject5).getString("type");
              str = ((JSONObject)localObject5).getString("name");
              localObject4 = ((JSONObject)localObject5).getString("title");
              localObject5 = ((JSONObject)localObject5).getString("num");
              if (Integer.parseInt((String)localObject5) <= 0) {
                break label636;
              }
              t localt = new t();
              localt.b((String)localObject3);
              localt.c(str);
              localt.d((String)localObject4);
              localt.e((String)localObject5);
              o.a().a(localt);
              break label636;
            }
          }
          if ((localObject1 != null) && (((JSONObject)localObject1).has("resrule")))
          {
            localObject1 = ((JSONObject)localObject1).getJSONArray("resrule");
            j = k;
            if (j < ((JSONArray)localObject1).length())
            {
              localObject4 = ((JSONArray)localObject1).getJSONObject(j);
              localObject2 = ((JSONObject)localObject4).getString("type");
              localObject3 = ((JSONObject)localObject4).getString("rank");
              str = ((JSONObject)localObject4).getString("derate_type");
              localObject4 = ((JSONObject)localObject4).getString("derate_num");
              localObject5 = new u();
              ((u)localObject5).a((String)localObject2);
              ((u)localObject5).a(Integer.parseInt((String)localObject3));
              ((u)localObject5).b(Integer.parseInt(str));
              ((u)localObject5).c(Integer.parseInt((String)localObject4));
              o.a().a((u)localObject5);
              j += 1;
              continue;
            }
          }
        }
        o.a().h();
        d(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label636:
      j += 1;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.i = "";
    this.h = paramJSONObject.toString();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseMpTitle :");
    ((StringBuilder)localObject).append(this.h);
    APLog.i("APMPSendInfo", ((StringBuilder)localObject).toString());
    try
    {
      if (paramJSONObject.has("mpinfo_ex"))
      {
        localObject = paramJSONObject.getJSONObject("mpinfo_ex").getString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.i = ((String)localObject);
          return;
        }
      }
      if (paramJSONObject.has("first_mpinfo_ex"))
      {
        localObject = paramJSONObject.getJSONObject("first_mpinfo_ex").getString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.i = ((String)localObject);
          return;
        }
      }
      if (paramJSONObject.has("acc_mpinfo_ex"))
      {
        localObject = paramJSONObject.getJSONObject("acc_mpinfo_ex").getString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.i = ((String)localObject);
          return;
        }
      }
      if (paramJSONObject.has("utp_mpinfo_ex"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("utp_mpinfo_ex").getString("title");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          this.i = paramJSONObject;
          return;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public int b()
  {
    if (g()) {
      return this.c.a.size();
    }
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public String b(String paramString)
  {
    if (!TextUtils.isEmpty(this.i)) {
      return this.i;
    }
    ad localad = a(this.d);
    StringBuffer localStringBuffer = new StringBuffer();
    if ((localad.b != null) && (ed.b().n().d.b))
    {
      localStringBuffer.append("首次充值");
      if (localad.b.a > 0) {
        localStringBuffer.append(localad.b.a);
      } else {
        localStringBuffer.append("任意数量");
      }
      localStringBuffer.append(paramString);
      localStringBuffer.append(",额外送");
      if (localad.b.a() > 0)
      {
        localStringBuffer.append(localad.b.a());
        localStringBuffer.append(paramString);
      }
      if ((localad.c != null) && (localad.c.size() > 0))
      {
        if (localad.b.a() > 0) {
          localStringBuffer.append('+');
        }
        localStringBuffer.append(i());
      }
    }
    return localStringBuffer.toString();
  }
  
  public y b(int paramInt)
  {
    boolean bool = g();
    Object localObject2 = null;
    Object localObject3;
    Object localObject1;
    if (bool)
    {
      localObject3 = this.c.a(paramInt);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = new y();
        ((y)localObject1).a = ((p)localObject3).a;
        ((y)localObject1).b = ((p)localObject3).a(((y)localObject1).a);
        ((y)localObject1).c = ((p)localObject3).b;
        ((y)localObject1).d = ((p)localObject3).c;
        ((y)localObject1).e = ((p)localObject3).a();
        return localObject1;
      }
    }
    else
    {
      localObject1 = localObject2;
      if (c())
      {
        localObject1 = localObject2;
        if (this.b != null)
        {
          localObject3 = b(paramInt, this.b);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = new y();
            ((y)localObject1).a = ((ad)localObject3).b.a;
            ((y)localObject1).b = ((ad)localObject3).b.a();
            ((y)localObject1).c = ((ad)localObject3).b.e;
            ((y)localObject1).d = ((ad)localObject3).c;
            ((y)localObject1).e = ((ad)localObject3).b();
          }
        }
      }
    }
    return localObject1;
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (this.b != null) {
      this.b.clear();
    }
    if (this.d != null) {
      this.d.a();
    }
    int j = 0;
    this.e = false;
    this.f = false;
    try
    {
      int k = paramJSONObject.getInt("firstsave_present_count");
      Object localObject;
      if (k > 0)
      {
        localObject = new s();
        ((s)localObject).a = 0;
        ((s)localObject).c = k;
        ((s)localObject).d = "2";
        this.d = new q();
        this.d.a = new ad();
        this.d.a.a = 1;
        this.d.a.b = ((s)localObject);
        this.e = true;
      }
      paramJSONObject = new JSONArray(paramJSONObject.getString("present_level"));
      while (j < paramJSONObject.length() / 2)
      {
        localObject = new q();
        s locals = new s();
        k = j * 2;
        locals.a = paramJSONObject.getInt(k);
        locals.c = paramJSONObject.getInt(k + 1);
        locals.d = "2";
        ((q)localObject).a = new ad();
        ((q)localObject).a.a = 1;
        ((q)localObject).a.b = locals;
        this.b.add(localObject);
        this.f = true;
        j += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public int c(int paramInt)
  {
    if (g()) {
      return this.c.b(paramInt);
    }
    if ((c()) && (this.b != null))
    {
      ad localad = b(paramInt, h());
      if (localad == null) {
        return 0;
      }
      if (localad.a == 2)
      {
        if (n(localad.b.a) > 0) {
          return m(localad.b.a);
        }
      }
      else if ((localad.a == 1) && (n(paramInt) > 0)) {
        return m(paramInt);
      }
    }
    return 0;
  }
  
  public String c(String paramString)
  {
    return b(paramString);
  }
  
  public void c(JSONObject paramJSONObject)
    throws JSONException
  {
    this.h = paramJSONObject.toString();
    w localw = w.a();
    localw.c();
    fn.b();
    if (paramJSONObject.has("tuan_mpinfo"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("tuan_mpinfo");
      localw.b(paramJSONObject.getString("mall_url"));
      localw.c(paramJSONObject.getString("result_url"));
      localw.d(paramJSONObject.getString("actset_id"));
      if (paramJSONObject.getJSONArray("list").length() > 0)
      {
        localw.a("1");
        return;
      }
      localw.a("0");
      return;
    }
    localw.a("0");
  }
  
  public boolean c()
  {
    int j = ed.b().n().a.saveType;
    return (this.f) && (j == 0);
  }
  
  public ArrayList<v> d(int paramInt)
  {
    Object localObject;
    if (g())
    {
      localObject = this.c.a(paramInt);
      if (localObject != null) {
        return ((p)localObject).c;
      }
    }
    else if ((c()) && (this.b != null))
    {
      localObject = b(paramInt, this.b);
      if (localObject != null) {
        return ((ad)localObject).c;
      }
    }
    return null;
  }
  
  public void d(JSONObject paramJSONObject)
  {
    w localw = w.a();
    localw.c();
    fn.b();
    try
    {
      if (paramJSONObject.has("tuan_mpinfo"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("tuan_mpinfo");
        localw.b(paramJSONObject.getString("mall_url"));
        localw.c(paramJSONObject.getString("result_url"));
        localw.d(paramJSONObject.getString("actset_id"));
        paramJSONObject = paramJSONObject.getJSONArray("list");
        if (a(paramJSONObject, "1"))
        {
          a(localw, paramJSONObject, "1");
          return;
        }
        if (a(paramJSONObject, "2"))
        {
          a(localw, paramJSONObject, "2");
          return;
        }
        if (a(paramJSONObject, "-1"))
        {
          a(localw, paramJSONObject, "-1");
          return;
        }
        localw.a("0");
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public boolean d()
  {
    int j = ed.b().n().a.saveType;
    return (this.e) && (j == 0);
  }
  
  public String e()
  {
    return this.i;
  }
  
  public ArrayList<v> e(int paramInt)
  {
    ec localec = ed.b().n();
    if (localec.a.saveType != 0) {
      return null;
    }
    ArrayList localArrayList1 = d(paramInt);
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = localArrayList1;
    if (localArrayList1 == null) {
      localObject = new ArrayList();
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList2.add((v)((Iterator)localObject).next());
    }
    paramInt = c(paramInt);
    if (paramInt > 0)
    {
      localObject = new v();
      ((v)localObject).a = localec.b.b;
      ((v)localObject).b = String.valueOf(paramInt);
      localArrayList2.add(0, localObject);
    }
    if (localArrayList2.size() > 0) {
      return localArrayList2;
    }
    return null;
  }
  
  public boolean e(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("first_mpinfo_ex"))
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject("first_mpinfo_ex");
        if ((localJSONObject.has("type")) && (!TextUtils.isEmpty(localJSONObject.getString("type")))) {
          return true;
        }
      }
      if (paramJSONObject.has("utp_mpinfo_ex"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("utp_mpinfo_ex");
        if (paramJSONObject.has("type"))
        {
          boolean bool = TextUtils.isEmpty(paramJSONObject.getString("type"));
          if (!bool) {
            return true;
          }
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      label88:
      break label88;
    }
    return false;
  }
  
  public int f(int paramInt)
  {
    if (ed.b().n().d.b) {
      return l(paramInt);
    }
    return 0;
  }
  
  public String f()
  {
    return this.h;
  }
  
  public ArrayList<v> g(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.d != null)
    {
      Object localObject = ed.b().n();
      ad localad = a(paramInt, this.d);
      if ((((ec)localObject).d.b) && (localad != null) && (localad.b != null))
      {
        int m = localad.a;
        int k = 0;
        int j = 0;
        if (m == 2)
        {
          if ((paramInt == localad.b.a) && (localad.c != null))
          {
            paramInt = j;
            while (paramInt < localad.c.size())
            {
              localObject = new v();
              ((v)localObject).a = ((v)localad.c.get(paramInt)).a;
              ((v)localObject).b = ((v)localad.c.get(paramInt)).b;
              localArrayList.add(localObject);
              paramInt += 1;
            }
          }
        }
        else if ((paramInt >= localad.b.a) && (localad.c != null))
        {
          paramInt = k;
          while (paramInt < localad.c.size())
          {
            localObject = new v();
            ((v)localObject).a = ((v)localad.c.get(paramInt)).a;
            ((v)localObject).b = ((v)localad.c.get(paramInt)).b;
            localArrayList.add(localObject);
            paramInt += 1;
          }
        }
      }
    }
    if (localArrayList.size() > 0) {
      return localArrayList;
    }
    return null;
  }
  
  public ArrayList<v> h(int paramInt)
  {
    ec localec = ed.b().n();
    ArrayList localArrayList1 = g(paramInt);
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = localArrayList1;
    if (localArrayList1 == null) {
      localObject = new ArrayList();
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList2.add((v)((Iterator)localObject).next());
    }
    paramInt = f(paramInt);
    if (paramInt > 0)
    {
      localObject = new v();
      ((v)localObject).a = localec.b.b;
      ((v)localObject).b = String.valueOf(paramInt);
      localArrayList2.add(0, localObject);
    }
    if (localArrayList2.size() > 0) {
      return localArrayList2;
    }
    return null;
  }
  
  public int i(int paramInt)
  {
    return c(paramInt) + f(paramInt);
  }
  
  public ArrayList<v> j(int paramInt)
  {
    ArrayList localArrayList = a(d(paramInt), g(paramInt));
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return localArrayList;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ac
 * JD-Core Version:    0.7.0.1
 */